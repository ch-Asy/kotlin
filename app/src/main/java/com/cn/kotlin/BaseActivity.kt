package com.cn.kotlin

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.media.AudioManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.support.v4.app.ActivityCompat
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.MotionEvent
import android.view.Window
import android.view.inputmethod.InputMethodManager
import android.widget.TextView


import java.util.ArrayList

import butterknife.ButterKnife
import butterknife.Unbinder

/**
 * Created by wang on 2016/8/9 9:24.
 */
abstract class BaseActivity : AppCompatActivity() {


    val SUCCESS = "操作成功"
    val SERVICE_ERROR = "服务器开小差了～"
    val DATA_NO_MORE = "没有更多数据了～"
    val DATA_NO = "没有数据～"




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)

        setContentView()

        initToolBar(savedInstanceState)
        setUpView()
        setUpData()
    }


    /**
     * 设置toolbar
     *
     * @param toolBar               toolbar 控件
     * @param title                 标题控件
     * @param titleNameRes          标题
     * @param isShowLeft            是否显示左边的图标
     * @param leftRes               左边图标的资源
     * @param onLeftOnClickListener 左边的监听
     */
    protected fun setToolBar(toolBar: Toolbar?, title: TextView?, titleNameRes: String,
                             isShowLeft: Boolean, leftRes: Int,
                             onLeftOnClickListener: onLeftOnClickListener?) {
        if (title != null) {
            title.text = titleNameRes
        }
        setSupportActionBar(toolBar)
        if (isShowLeft) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            toolBar!!.setNavigationIcon(leftRes)
            toolBar!!.setNavigationOnClickListener {
                onLeftOnClickListener?.onLeftClick()
            }
        }
        //不显示默认的标题
        supportActionBar!!.setDisplayShowTitleEnabled(false)
    }

    /**
     * 设置toolbar
     *
     * @param savedInstanceState
     */
    protected abstract fun initToolBar(savedInstanceState: Bundle?)

    /**
     * 子类初始化view 请求数据前获取数据参数等
     */
    protected abstract fun setUpView()


    /**
     * 子类初始化数据
     */
    protected abstract fun setUpData()

    protected abstract fun getLayoutId():Int

    /**
     * 设置布局
     */
    protected fun setContentView() {
        setContentView(getLayoutId())
    }





    interface onLeftOnClickListener {
        fun onLeftClick()
    }


    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (null != this.currentFocus) {
            val mInputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            return mInputMethodManager.hideSoftInputFromWindow(this.currentFocus!!.windowToken, 0)
        }
        return super.onTouchEvent(event)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        val fragmentManager = supportFragmentManager

        if (fragmentManager.fragments != null) {
            for (indext in 0 until fragmentManager.fragments.size) {
                val fragment = fragmentManager.fragments[indext] //找到第一层Fragment
                if (fragment == null)
                    Log.w("base", "Activity result no fragment exists for index: 0x" + Integer.toHexString(requestCode))
                else
                    handleResult(fragment, requestCode, resultCode, data)
            }
        }
    }

    /**
     * 递归调用，对所有的子Fragment生效
     *
     * @param fragment
     * @param requestCode
     * @param resultCode
     * @param data
     */
    private fun handleResult(fragment: Fragment, requestCode: Int, resultCode: Int, data: Intent) {
        fragment.onActivityResult(requestCode, resultCode, data)//调用每个Fragment的onActivityResult
        Log.w("base", "MyBaseFragmentActivity")
        val childFragment = fragment.childFragmentManager.fragments //找到第二层Fragment
        if (childFragment != null)
            for (f in childFragment)
                if (f != null) {
                    handleResult(f, requestCode, resultCode, data)
                }
        if (childFragment == null)
            Log.w("base", "MyBaseFragmentActivity1111")
    }

}
