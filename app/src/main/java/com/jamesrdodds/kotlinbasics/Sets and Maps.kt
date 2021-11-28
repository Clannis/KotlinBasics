package com.jamesrdodds.kotlinbasics

fun main() {

    // Sets cannot have more than one of same element
    val fruits = setOf("Orange", "Apple", "Mango", "Grape", "Apple", "Orange")
//    print(fruits.toSortedSet())

    val newFruits = fruits.toMutableList()
    newFruits.add("Watermelon")
    newFruits.add("Pear")
//    print(newFruits.elementAt(4))

    val daysOfTheWeek = mapOf(1 to "Monday", 2 to "Tuesday", 3 to "Wednesday")
//    print(daysOfTheWeek[2])
    for(key in daysOfTheWeek.keys) {
        println("$key is to ${daysOfTheWeek[key]}")
    }

    val fruitsMap = mapOf("Favorite" to Fruits("Grape", 2.5),
        "OK" to Fruits("Apple", 1.0))

    for(key in fruitsMap.keys) {
        println("$key is to ${fruitsMap[key]}")
    }

    val newDaysOfWeek = daysOfTheWeek.toMutableMap()
    newDaysOfWeek[4] = "Thursday"
    newDaysOfWeek[5] = "Friday"

    println(newDaysOfWeek.toSortedMap()) // sorted by key
}

data class Fruits(val name: String, val price: Double)