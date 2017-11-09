package com.emof.util

import android.content.Context
import android.support.v4.app.Fragment
import android.widget.Toast

/**
 * Created by anliyuan on 2017/11/9.
 */
/**
 * Toast提示信息的提示
 *
 */
fun Context.toast(msg: Any?, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this,getString(msg), duration)
}
fun Fragment.toast(msg: Any?, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(activity,activity.getString(msg), duration)
}