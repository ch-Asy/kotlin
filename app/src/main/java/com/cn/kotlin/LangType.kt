package com.cn.kotlin

/**
 * Created by anliyuan on 2017/9/19.
 */

enum class LangType(var lang: String) {
    ENGLISH("hello"),
    CHINESE("您好");




    init {

    }

    fun sayHello() {
        println(lang)
    }

    companion object {
        fun parse(string: String) = LangType.valueOf(string.toUpperCase())
    }
}