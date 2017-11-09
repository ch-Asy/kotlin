package com.emof.util

import android.content.Context
import com.emof.base.BaseActivity
import com.emof.base.BaseFragment

/**
 * Created by anliyuan on 2017/11/9.
 */
fun Context.getActivity(): BaseActivity? {
    var activity: BaseActivity? = null
    if (this is BaseActivity) {
        activity = this
    } else if (this is BaseFragment) {
        activity = this.activity as BaseActivity
    }
    return activity
}