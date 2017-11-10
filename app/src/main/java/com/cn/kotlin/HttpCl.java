package com.cn.kotlin;

import com.ann.http.HttpMethods;
import com.ann.http.ProgressSubscriber;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by anliyuan on 2017/11/10.
 */

public class HttpCl {
    /**
     * 网络请求的service,
     * 需要请求哪个接口，就调用HttpService的相应方法即可
     */
    private HttpService httpService;

    private static int cacheTime;

    public HttpCl() {
        Retrofit retrofit = HttpMethods.HttpMethods(cacheTime);
        httpService = retrofit.create(HttpService.class);
    }


    public void banner(ProgressSubscriber<BannerData> subscriber){
        subscribeOnIo(httpService.BannerData(),subscriber);
    }

    /**
     * 在子线程中进行网络请求，在主线程处理结果
     * 这是一个泛型方法
     * Observable的泛型和Subscriber中的泛型一样
     *
     * @param observable Observable流
     * @param subscriber 观察者对象 -----回调
     */
    private  <T> void subscribeOnIo(Observable<T> observable, Observer<T> subscriber) {
        if (subscriber != null && observable != null) {
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(subscriber);
        }
    }
    /**
     * 单例
     *
     * @param time 缓存的过期时间
     * @return 返回HttpMethods类的唯一实例
     */
    public static HttpCl getInstance(int time) {
        cacheTime = time;
        return SingletonHolder.INSTANCE;
    }



    /**
     * 获取单例的静态内部类
     */
    private static class SingletonHolder {
        private static HttpCl INSTANCE = new HttpCl();
    }

}
