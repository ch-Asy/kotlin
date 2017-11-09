package com.emof.util

import android.content.Context
import com.emof.iml.LayoutResId

/**
 * Created by anliyuan on 2017/11/9.
 */
/**
 * 用于获取布局文件
 */
fun Context.getLayoutResId(): Int? {
    var id:Int?=null
    val clazz = this.javaClass
    if (clazz.annotations != null) {
        if (clazz.isAnnotationPresent(LayoutResId::class.java)) {
            val layoutResId = clazz.getAnnotation(LayoutResId::class.java)
            id = layoutResId.resId
        }
    }
    return id
}