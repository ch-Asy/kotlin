package com.emof.util

import android.content.Context
import android.support.v7.widget.Toolbar
import android.widget.TextView
import com.emof.base.BaseActivity
import com.emof.iml.OnToolbarClickListener

/**
 * Created by anliyuan on 2017/11/9.
 */
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
fun Context.setToolBar(toolBar: Toolbar, title: TextView?,
                       titleNameRes: Any, isShowLeft: Boolean = true,
                       leftRes: Int, listener: OnToolbarClickListener? = null) {
    var activity: BaseActivity? = getActivity()
    title?.text = getString(titleNameRes)
    activity!!.setSupportActionBar(toolBar)
    if (isShowLeft) {
        activity!!.getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true)
        toolBar.setNavigationIcon(leftRes)
        toolBar.setNavigationOnClickListener {
            if (listener != null) {
                activity!!.closePageAnim()
                listener!!.onCancelClickListener()
            }
        }
    }
    //不显示默认的标题
    activity!!.getSupportActionBar()!!.setDisplayShowTitleEnabled(false)
}