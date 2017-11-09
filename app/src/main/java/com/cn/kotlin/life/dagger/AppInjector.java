package com.cn.kotlin.life.dagger;


import com.cn.kotlin.App;


/**
 * Helper class to automatically inject fragments if they implement {@link Injectable}.
 */
public class AppInjector {
    private AppInjector() {
    }

    public static void init(App app) {
        DaggerAppComponent.builder().build().inject(app);

    }


}