package com.emof.base

import android.content.Context
import android.support.multidex.MultiDex
import android.support.multidex.MultiDexApplication
import com.zhy.autolayout.config.AutoLayoutConifg


abstract class BaseApplication : MultiDexApplication() {
    companion object {
        var instance: Context? = null
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        //自适应布局
        if (setAutoLayout()) AutoLayoutConifg.getInstance().useDeviceSize();
        MultiDex.install(this)
        initSet()
    }

    /**
     * 是否开启物理尺寸
     */
    abstract fun setAutoLayout(): Boolean

    /**
     * 用于初始化其他设置
     */
    abstract fun initSet();

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }


}
