package com.example.sp22_bse_6a_demo.basics


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


data class Person(
    var name: Name,
    var age: Int,
    var email: String
) {
    override fun toString(): String {
        return "Person(nam=$name, age=$age, email=$email)\n"
    }
}

data class Name(
    var firstName: String,
    var middelName: String,
    var lastName: String
)