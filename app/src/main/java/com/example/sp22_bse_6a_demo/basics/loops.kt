package com.example.sp22_bse_6a_demo.basics

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.example.sp22_bse_6a_demo.models.Person

fun main() {

//    var i: Int = 0
//
//    while(i<=10) {
//        println("i = $i")
//        i++
//    }

//    for (i in 1..10) {
//        println("i = $i")
//    }
//    (1..10).forEach {parentNumber ->
//        print("current value  = $parentNumber")
//        (11..20).forEach {
//            println("current nested value  = $it --- $parentNumber")
//
//        }
//    }

//    filterData()

//    personList.forEach {person ->
//        println("current person fname -> ${person.name.firstName}")
//        println("current person mname -> ${person.name.middelName}")
//        println("current person lname -> ${person.name.lastName}")
//
//        println("current person age-> ${person.age}")
//        println("current person email-> ${person.email}")
//
//    }
//
//    for (person in personList) {
//        println("person  = $person")
//    }

//     val list: MutableList<Person> = arrayListOf()
//
//    list.add(Person(Name("A","B","C"), age = 20, email = "abc@gmail.com"))
//    list.add(Person(Name("A","B","C"), age = 20, email = "abc@gmail.com"))
//    list.add(Person(Name("A","B","C"), age = 20, email = "abc@gmail.com"))
//    list.add(Person(Name("A","B","C"), age = 20, email = "abc@gmail.com"))
//    list.add(Person(Name("A","B","C"), age = 20, email = "abc@gmail.com"))

//    print("lists = ${list.get(0)}")


    // Mapping

    val personList = arrayListOf(Person(Name("Ali", "", "Usman"), 29, "ali@gmail.com"),
        Person(Name("Maowiz", "", "Saleem"), 21, "Maowiz@gmail.com"),
        Person(Name("Umar", "", "Draz"), 20, "umar@gmail.com")
    )

//    val names = getPersonsName(personsList = personList)
    println("Names  = ${Person().getPersonsName(personsList = personList)}")
}

fun filterData(){
    val personList = arrayListOf(Person(Name("Ali", "", "Usman"), 29, "ali@gmail.com"),
        Person(Name("Maowiz", "", "Saleem"), 21, "Maowiz@gmail.com"),
        Person(Name("Umar", "", "Draz"), 20, "umar@gmail.com")
    )

    val filteredData = personList.filter {
        (it.age?:0) <= 21 && it.name?.firstName?.contains("o")?:false
    }

    println("filteredData -> $filteredData")

    val age: String = "${20}";
}

