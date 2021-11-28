package com.jamesrdodds.kotlinbasics

import java.lang.IllegalArgumentException
import java.util.*

fun main() {
    var james = Person("James", "Dodds", 30)
    james.hobby = "skateboard"
    james.stateHobby()
//    var john = Person()
//    var peterson = Person(lastName = "Peterson")


    var eightT = MobilePhone("Android", "OnePlus", "8T")
//    var nineProT = MobilePhone("Android", "OnePlus", "9 Pro")
//    var samsungG8 = MobilePhone("Android", "Samsung", "Galaxy 8")
    eightT.chargeBattery(30)

    var myCar = Car()
    println("Brand is ${myCar.myBrand}")
    myCar.maxSpeed = 200
    println("maxSpeed is ${myCar.maxSpeed}")
    println("Model is ${myCar.myModel}")

    val user1 = User(1, "James")
    println(user1.name)
    user1.name = "Michael"
    println(user1.name)

    val user2 = User(1, "Michael")
    println(user1 == user2)

    println("User details: $user1")

    val updatedUser = user1.copy(name="James")
    println(updatedUser)

    println(updatedUser.component1())
    println(updatedUser.component2())

    val (id,name) = updatedUser
    println("$id $name")
}

class Person(firstName: String = "John", lastName: String = "Doe") {
    // Member Variables - Properties
    var firstName: String? = null
    var lastName: String? = null
    var age: Int? = null
    var hobby = "watch Netflix"

    // Initializer - Code will run on initialization of instance
    init{
        this.firstName = firstName
        this.lastName = lastName
        println("Initialized a new person. They are $firstName $lastName.")
    }
    // Secondary Constructor
    constructor(firstName: String = "John", lastName: String = "Doe", age: Int)
            : this(firstName, lastName){
        this.age = age
    }

    // Member Functions - Methods
    fun stateHobby(){
        println("$firstName's hobby is to $hobby.")
    }
}

class MobilePhone(osName: String, brand: String, model: String){
    private var battery = 50

    init{
        println("This is a $brand $model running $osName.")
    }

    fun chargeBattery(chargeAmount: Int){
        println("The phone had $battery% charge. It was charged by $chargeAmount% and now has ${battery + chargeAmount}%.")
        battery += chargeAmount
    }
}

class Car(){
    lateinit var owner : String

    val myBrand: String = "BMW"
        // custom getter
        get() {
            return field.lowercase()
        }

    var maxSpeed : Int = 250
        // get() = field
        set(value){
            field = if(value > 0) value else throw IllegalArgumentException("Max Speed must be greater than 0.")
        }

    var myModel: String = "M5"
        private set

    init{
        myModel = "M3"
        this.owner = "Frank"
    }
}

data class User(val id: Long, var name: String)