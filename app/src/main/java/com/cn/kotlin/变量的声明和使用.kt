package com.cn.kotlin

import java.math.BigInteger
import java.util.*

/**
 * Created by anliyuan on 2017/9/13.
 */
fun main(args: Array<String>) : Unit{
    //第一次赋值后类型就被指定了
    //不赋值也不声明类型就会保存就会报错
    //var 变量
    //val 常量 不可以被修改

    var long: Long = Long.MIN_VALUE
    var byte: Byte = 127

    args.map(::print)

    var value = "只读的数据类型"

//    value.equals(value,true)


    val a = Math.sqrt(5.0)
//
//    long = value.toLong()
//    name="asy"
    long = 9000000000000000000

    var isT: Any? = 10.0
    when (isT) {
        is Long -> println("long")
        is Int -> println("int")
        10.toInt() -> println("10")
    }

//    for (a in 1 until 100 step 2) {
//        println(a)
//    }
    val readLine1 = readLine()
    val readLine2 = readLine()

    try {
        var num1: Int = readLine1!!.toInt()
        var num2: Int = readLine2!!.toInt()
        println("${num1}+${num2}=${num1 + num2}")
    } catch (e: NumberFormatException) {
        println("请请输入正确的数字")
    }

    val fun12 = { a: Int, b: Int -> a + b }
    val fun121 = fun12(1, 3)
    println(fun121)
    val fun123: (Int, Int) -> Int = { a, b -> a + b }
    val fun1231 = fun123(1, 3)
    println(fun1231)
//    val feat={a:Int->a}
    var message = BigInteger("100")
    println(feat(message))

    println(addI(10,0))
}


fun addInt(a: Int, b: Int): Int {
    return a + b
}


fun feat(a : BigInteger):BigInteger{
    if (a == BigInteger.ONE) {
        return BigInteger.ONE
    } else {
        return a* feat(a- BigInteger.ONE)
    }
}

tailrec fun addI(num:Int,result:Int):Int{
    println("${num},${result}")
    if (num == 1) {
        return num + result
    } else {
        return addI(num-1,result+num)
    }
}

fun addDouble(a: Double, b: Double): Double = a + b