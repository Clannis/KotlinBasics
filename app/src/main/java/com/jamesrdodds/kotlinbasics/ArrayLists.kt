package com.jamesrdodds.kotlinbasics

fun main() {
    val arrayList1 = ArrayList<String>() // Create empty arrayList
    arrayList1.add("One")    // Adding an object to the arraylist
    arrayList1.add("Two")
    println("......print ArrayList.....")
    for(i in arrayList1){
        println(i)
    }

    val arrayList2: ArrayList<String> = ArrayList<String>(5)
    var list: MutableList<String> = mutableListOf<String>()
    list.add("One")
    list.add("Two")
    arrayList2.addAll(list)
    println("......print ArrayList.....")
    val itr = arrayList2.iterator()
    while(itr.hasNext()){
        println(itr.next())
    }
    println("Size of arrayList = " + arrayList2.size)

    val arrayList3: ArrayList<String> = ArrayList<String>()
    arrayList3.add("One")
    arrayList3.add("Two")
    println("......print ArrayList.....")
    for(i in arrayList3){
        println(i)
    }
    println(".....arrayList3.get(1).....")
    println(arrayList3.get(1))
}