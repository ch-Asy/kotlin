package com.cn.kotlin

import java.net.URL

/**
 * Package :com.cn.kotlin.
 * Author :ann.
 * Time:2016/11/29_14:43.
 */
public class Request(val url:String){
    public fun run(): String {
        val readText = URL(url).readText()
        return readText
    }
}