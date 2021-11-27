package com.jamesrdodds.kotlinbasics

fun main() {
    var james = Person("James", "Dodds")
    var john = Person()
    var peterson = Person(lastName = "Peterson")
}

class Person(firstName: String = "John", lastName: String = "Doe") {

    // Initializer
    init{
        println("Initialized a new person. They are $firstName $lastName.")
    }
}
