package com.jamesrdodds.kotlinbasics

class OuterClass() {
    private var name = "Mr X"

    class NestedClass() {
        var description = "code inside nested class"
        private var id = 101
        fun foo() {
            // print("name is $name") // cannot access outer class member
            print("Id is $id")
        }
    }

    inner class InnerClass() {
        var description = "code inside nested class"
        private var id = 101
        fun foo() {
            print("name is $name") // can access the private outer class member
            print("Id is $id")
        }
    }
}

fun main() {
    // nested class must be initialized
    println(OuterClass.NestedClass().description) // accessing property of nested class

    var obj = OuterClass.NestedClass() // object creation
    obj.foo() // access member function of nested class

    // Output: code inside nested class
    //         Id is 101


    println(OuterClass().InnerClass().description) // accessing property of inner class

    var obj2 = OuterClass().InnerClass() // object creation
    obj2.foo() // access member function of inner class

    // Output: code inside nested class
    //         name is Mr X
    //         Id is 101
}