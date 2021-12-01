package com.jamesrdodds.kotlinbasics

import java.lang.ArithmeticException
import java.lang.NullPointerException

// Exception: runtime problem which occurs in the program and leads to program termination
// Examples: running out of memory, array out of bounds, or condition like divided by zero

// Exception Handling will handle the runtime problems and maintain the flow of program execution. (i.e. Wont crash your app)

fun main() {
    val str = getNumber("10") // The variable str is getting the int value of "10.5"
    println(str)
    // Output: 10

    val str1 = getNumber("10.5") // The variable str is getting the int value of "10.5"
    println(str1)

    // Output: 0

    try {
        val a = IntArray(5)
        a[5] = 10 /0
    } catch(e: ArithmeticException) {
        println("Arithmetic Exception catch")
    } catch(e: ArrayIndexOutOfBoundsException) {
        println("array index out of bounds exception")
    } catch(e: Exception) {
        println("parent exception class")
    } // Output: Arithmetic Exception catch

    try {
        val data = 10/5
        println(data)
    } catch (e: NullPointerException) {
        println(e)
    } finally {
        println("Finally block always executes")
    }

    // Output: 2
    //         Finally block always executes

    validate(15)
    println("cade after validation check...")

    // Output: Exception in thread "main" java.lang.ArithmeticException : Under Age
}

fun getNumber(str: String): Int {
    return try {
        Integer.parseInt(str)
    } catch (e: ArithmeticException) {
        0
    }
}

fun validate(age: Int) {
    if(age < 18)
        throw ArithmeticException("Under Age")
    else
        println("eligible to drive")
}
