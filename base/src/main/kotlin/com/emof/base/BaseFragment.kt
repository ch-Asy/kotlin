package com.emof.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.emof.util.getLayoutResId

/**
 * Created by anliyuan on 2017/11/9.
 */
abstract class BaseFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(activity.getLayoutResId()!!, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
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