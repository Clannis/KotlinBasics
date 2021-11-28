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

    var myCar = Cars()
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

    var audiA3 = Car(200.0,"A3", "Audi")
    var teslaS = ElectricCar(240.0,"S", "Tesla", 85.0)
    teslaS.chargerType = "Type2"
    teslaS.extendRange(200.0)

//    teslaS.drive()
    teslaS.brake()
    audiA3.brake()
    // Polymorphism
//    audiA3.drive(200.0)
//    teslaS.drive(200.0)

    val human = Human("James", "USA", 260.0, 28.0)
    val elephant = Elephant("Bootsy", "Africa", 5400.0, 34.0)

    human.run()
    elephant.run()

    human.breath()
    elephant.breath()
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

class Cars(){
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

interface Drivable{
    val maxSpeed: Double
    fun drive(): String
    fun brake(){
        println("The drivable is braking.")
    }
}

// class must be open to be inheritable
// Parent Class of ElectricCar
open class Car(override val maxSpeed: Double, val name: String, val brand:String): Drivable{
    open var range: Double = 0.0

    fun extendRange(amount: Double){
        if(amount > 0)
            range+= amount
    }

    override fun drive(): String{
        return "driving the interface drive"
    }

    open fun drive(distance: Double){
        println("Drove for $distance KM.")
    }
}

// Child Class of Car
class ElectricCar(maxSpeed: Double, name: String, brand: String, batteryLife: Double)
    : Car(maxSpeed, name, brand){

    var chargerType = "Type1"
    override var range = batteryLife * 6

    override fun drive(distance: Double){
        println("Drove for $distance KM on electricity.")
    }

    override fun drive(): String{
        return "Can drive for $range KM on electricity."
    }

    override fun brake() {
        super.brake()
        println("Brake inside of the electric car.")
    }
}

abstract class Mammal(private val name: String, private val origin: String,
    private val weight: Double) { // Concrete (Non-Abstract) Properties

    // Abstract Property (Must be overridden by Subclasses)
    abstract var maxSpeed: Double

    // Abstract Methods (Must be overridden by subclasses)
    abstract fun run()
    abstract fun breath()

    // Concrete (Non-Abstract) Method
    fun displayDetails() {
        println("Name: $name, Origin: $origin, Weight: $weight, " +
                "Max Speed: $maxSpeed.")
    }
}

class Human(name: String, origin: String, weight: Double,
            override var maxSpeed: Double): Mammal(name, origin, weight) {

    override fun run() {
        // Code to run
        println("Runs on two legs")
    }

    override fun breath() {
        // Code to breath
        println("Breaths through mouth and nose")
    }
}

class Elephant(name: String, origin: String, weight: Double,
               override var maxSpeed: Double): Mammal(name, origin, weight) {

   override fun run() {
       // Code to run
       println("Runs on four legs")
   }

    override fun breath() {
        // Code to breath
        println("Breaths through the trunk")
    }
}