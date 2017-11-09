package com.cn.kotlin

/**
 * Package :com.cn.kotlin.
 * Author :ann.
 * Time:2016/11/29_11:47.
 */
/**
 * 方法的形式，范围值unit为空，是一个对象
 * 一行能表示的可以省去大括号
 */
fun add(num1:Int,num2:Int): Unit{
//    return num1+num2
}
fun add(num1:Int,num2:Int,num3:Int):Int=num1+num2+num3
/**
 * 类和类的继承
 * 只能继承open 和abstract类
 */
open class Person(name: String, age: Int) {//没有任何的操作大括号是可以省略的
init {
    //函数体
}
}

//abstract class Animal(name: String)

//class Child(name: String, age: Int) : Animal(name)

