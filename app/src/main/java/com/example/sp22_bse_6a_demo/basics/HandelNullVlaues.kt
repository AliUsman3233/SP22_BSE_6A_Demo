package com.example.sp22_bse_6a_demo.basics

import com.example.sp22_bse_6a_demo.models.Person


fun main() {

    var a: Int? = 5
    var b: Int? = 7

    // val sum = a!! + b!! // NullPointerException

//    val sum = (a ?: 0) + (b ?: 0)   // else wise operator
//    println("Sum  = ${sum(a, b)}")
    // dealWithStrings()

    val p: Person? = Person(Name("Ali", "", "Usman"), 29, "ali@gmail.com")

    println("person age  = ${p?.age ?: 0}")
}


fun sum(x: Int?, y: Int?): Int? {
    val sum = (x ?: 0) + (y ?: 0)   // else wise operator
    return sum
}

fun dealWithStrings() {
    val message: String? = "Ali Usman"
    print("message length is = ${message?.length ?: 0}")
}

