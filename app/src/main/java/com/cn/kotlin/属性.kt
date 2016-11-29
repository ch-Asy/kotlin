package com.cn.kotlin

/**
 * Package :com.cn.kotlin.
 * Author :ann.
 * Time:2016/11/29_14:25.
 */
fun main(args: Array<String>) {
    val person=Person2();
    person.name="ansy"
    val name=person.name
    print("$name")
}
public class Person2{
    var name="";
    get() = field.toUpperCase()
    set(value) {
        field = "String: $value"
    }
}