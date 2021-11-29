package com.jamesrdodds.kotlinbasics

fun main() {
    addNumbers(5,10)
    val sum: (Int, Int) -> Int = {a: Int, b: Int -> a + b}
    println(sum(11,5))
    val sum2 = {a:Int, b:Int -> println(a+b)}
    sum2(12,5)
}

fun addNumbers(a: Int, b: Int) {
    val sum = a + b
    println(sum)
}