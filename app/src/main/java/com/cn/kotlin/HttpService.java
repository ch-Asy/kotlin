package com.cn.kotlin;

import io.reactivex.Observable;
import retrofit2.http.POST;

/**
 * Created by anliyuan on 2017/11/10.
 */

public interface HttpService {
    /**
     * 首页轮播图
     */
    @POST("adv_move/listpage")
    Observable<BannerData> BannerData();
}
