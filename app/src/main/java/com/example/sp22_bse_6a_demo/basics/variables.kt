package com.example.sp22_bse_6a_demo.basics

import com.example.sp22_bse_6a_demo.models.Person


fun main() {
    val PI = 3.14
    //int a = 20; // c++
    var name: String = "Ali Usman" // Kotlin
    name = "Mr. Ali Usman"

    println("Your name is  = $name")
    println("Value of PI  = $PI")


    val name1 = Name("Ali", "", "Usman")
    var p: Person = Person(name1, age = 29, "ali@gmail.com")

    println("Name of person  = ${p.toString()}")
}


data class Name(
    var firstName: String,
    var middelName: String,
    var lastName: String
)