package com.jamesrdodds.kotlinbasics

// as = unsafe casting operator
// as? = safe casting operator. returns a null if casting is not possible instead of an exception

fun main() {
    val obj: Any? = null
//    val str: String = obj as String
//    println(str)

    // Output: Exception in thread "main" java.lang.ClassCastException: null cannot be cast to a non-null type kotlin.String.

    val obj3: Any = 123
    val str3: String = obj3 as String
    println(str3)

    // Output: Exception in thread "main" java.lang.ClassCastException: class java.lang.Integer cannot be cast to class java.lang.String.

    val obj2: Any? = "String unsafe cast"
    val str2: String? = obj2 as String?
    println(str2)

    // Output: String unsafe cast

    val location: Any = "Kotlin"
    val safeString: String? = location as? String
    val safeInt: Int? = location as? Int
    println(safeString)
    println(safeInt)

    // Output: Kotlin
    //         null
}