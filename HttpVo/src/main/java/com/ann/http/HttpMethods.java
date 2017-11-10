package com.ann.http;

import android.content.Context;

import com.ann.http.util.NetworkUtils;
import com.emof.base.BaseApplication;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 网络请求方法的集合类，该类初始化了Retrofit，封装了RxJava
 * Created by an on 2016/8/18 13:48.
 */
public class HttpMethods {

    private static final String TAG = HttpMethods.class.getSimpleName();

    /**
     * 超时时间 ：s
     */
    private static final int DEFAULT_TIMEOUT = 12;

    /**
     * 长期缓存的时间
     */
    public static final int LONG_CACHE = 60 * 60 * 24 * 365;



    /**
     * 单例模式
     * 私有化构造方法
     * 在构造方法中完成对OkHttpClient、Retrofit、HttpService的初始化
     * <p/>
     * <p/>
     * <li>{@link OkHttpClient}</li>
     * <li>{@link Retrofit}</li>
     * <li>{@link HttpLoggingInterceptor.Level}</li>
     * <li>{@link RxJava2CallAdapterFactory}</li>
     */
    public static Retrofit HttpMethods(final int cacheTime) {
        /*
        打印log
        以及log的级别
         */
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        final Context context = BaseApplication.Companion.getInstance();
        File cacheFile = new File(context.getCacheDir(), context.getString(R.string.app_name)+"_cache");

        //设置缓存最大1G
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 1024);

        //设置缓存的拦截器
        //设置缓存的拦截器
        Interceptor cacheInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) {
                //将请求拦截下来
                Request request = chain.request();
                //没网，强制取缓存
                if (!NetworkUtils.isAvailable(context)) {
                    request = request.newBuilder()
                            .cacheControl(CacheControl.FORCE_CACHE)
                            .build();
                    if (request == null) {
                        return null;
                    }
                }

                Response response = null;
                try {
                    response = chain.proceed(request);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Response responseLatest;
                //网络可用，设置缓存的过期时间
                if (NetworkUtils.isAvailable(context)) {
                    responseLatest = response.newBuilder().header("Cache-Control", "public, max-age=" + cacheTime)
                            .build();
                } else {
                    //没网
                    int maxStale = 60 * 60 * 24 * 28; // tolerate 4-weeks stale没网的时候，设置缓存过期时间4周
                    responseLatest = response.newBuilder().removeHeader("Pragma")
                            .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                            .build();
                }

                return responseLatest;
            }
        };


        /*OKHttpClient对象*/
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
//                .addInterceptor(cacheInterceptor).cache(cache)
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .build();


        /*Retrofit对象*/
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(NetUtils.BASE_URL)
                .client(okHttpClient)
                .build();

        return retrofit;

    }

}
