package com.cn.kotlin;

import android.app.Application;

import com.cn.kotlin.life.dagger.AppInjector;
import com.emof.base.BaseApplication;
//import com.emof.base.BaseApplication;


public class App extends BaseApplication {

    public void onCreate() {
        super.onCreate();
        AppInjector.init(this);
    }

    @Override
    public boolean setAutoLayout() {
        return true;
    }

    @Override
    public void initSet() {

    }
}
