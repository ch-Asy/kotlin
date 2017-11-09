package com.emof.util

import android.content.Context
import com.emof.R
import com.emof.base.BaseActivity

/**
 * Created by anliyuan on 2017/11/9.
 */


/**
 * 关闭一个界面的动画
 *
 * @param close_enter 关闭开始动画
 * @param close_exit 关闭结束动画
 */
fun Context.closePageAnim(close_enter: Int = R.anim.close_activity_enter,
                          close_exit: Int = R.anim.close_activity_exit): Unit {
    var activity: BaseActivity? = getActivity()
    activity!!.overridePendingTransition(close_enter, close_exit)
}

/**
 * 打开activity并运行动画
 *
 * @param open_enter 打开开始动画
 * @param open_exit 打开结束动画
 */
fun Context.openPageAnim(open_enter: Int = R.anim.open_activity_enter,
                         open_exit: Int = R.anim.open_activity_exit): Unit {
    var activity: BaseActivity? = getActivity()
    activity!!.overridePendingTransition(open_enter, open_exit)
}



