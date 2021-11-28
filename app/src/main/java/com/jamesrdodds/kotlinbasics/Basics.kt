package com.jamesrdodds.kotlinbasics

fun main() {
    var james = Person("James", "Dodds", 30)
    james.hobby = "skateboard"
    james.stateHobby()
//    var john = Person()
//    var peterson = Person(lastName = "Peterson")


//    var eightT = MobilePhone("Android", "OnePlus", "8T")
//    var nineProT = MobilePhone("Android", "OnePlus", "9 Pro")
//    var samsungG8 = MobilePhone("Android", "Samsung", "Galaxy 8")

}

class Person(firstName: String = "John", lastName: String = "Doe") {
    // Member Variables - Properties
    var firstName: String? = null
    var lastName: String? = null
    var age: Int? = null
    var hobby = "watch Netflix"

    // Initializer - Code will run on initialization of instance
    init{
        println("Initialized a new person. They are $firstName $lastName.")
    }
    // Secondary Constructor
    constructor(firstName: String = "John", lastName: String = "Doe", age: Int)
            : this(firstName, lastName){
        this.age = age
        this.firstName = firstName
        this.lastName = lastName
    }

    // Member Functions - Methods
    fun stateHobby(){
        println("$firstName's hobby is to $hobby.")
    }
}

class MobilePhone(osName: String, brand: String, model: String){

    init{
        println("This is a $brand $model running $osName.")
    }
}