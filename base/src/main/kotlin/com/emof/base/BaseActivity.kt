package com.emof.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.emof.util.getLayoutResId

/**
 * Created by anliyuan on 2017/11/9.
 */
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResId()!!)
        initData()
        setToolbar(savedInstanceState)
        initView()
        beginServer()
    }


    /**
     * 用于设置toolbar
     */

    protected abstract fun setToolbar(savedInstanceState: Bundle?)

    /**
     * 用于初始化数据
     */
    protected abstract fun initData()

    /**
     * 用于初始化view
     */
    protected abstract fun initView()

    /**
     * 用于开始网络请求
     */
    protected abstract fun beginServer()


}