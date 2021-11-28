package com.jamesrdodds.kotlinbasics

fun main() {

    val months = listOf("Jan", "Feb", "Mar")
    val anyTypes = listOf(1,2,3,true,"String")

//    println(anyTypes.size)
//    println(months[1])

    for(month in months) {
        println(month)
    }

    val additionalMonths = months.toMutableList()
    val newMonthsList = arrayOf("Apr", "May", "Jun")
    additionalMonths.addAll(newMonthsList)
    additionalMonths.add("Jul")
    println(additionalMonths)

    val days = mutableListOf<String>("Mon", "Tues", "Wed")
    days.add("Thurs")
    days[2] = "Sun"
//    days.removeAt(3)
    val removeList = mutableListOf<String>("Mon", "Wed")
//    days.removeAll(removeList)
    days.removeAll(days)
    println(days)
}