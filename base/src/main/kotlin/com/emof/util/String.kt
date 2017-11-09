package com.emof.util

import android.content.Context

/**
 * Created by anliyuan on 2017/11/9.
 */

/**
 * 转换成字符串
 *
 * @param str 字符串资源资源
 * @see 现在只支持字符串字符串资源转换
 * @return String
 */
fun Context.getString(strRes: Any?): String? {
    when (strRes) {
        is String -> return strRes
        is Int -> return resources.getString(strRes)
    }
    return null
}