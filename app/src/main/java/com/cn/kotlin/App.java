package com.cn.kotlin;

import android.app.Application;

import com.cn.kotlin.life.dagger.AppInjector;


public class App extends Application {

    public void onCreate() {
        super.onCreate();
        AppInjector.init(this);
    }

}
