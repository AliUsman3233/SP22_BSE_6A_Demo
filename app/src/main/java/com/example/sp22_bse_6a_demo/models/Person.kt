package com.example.sp22_bse_6a_demo.models

import com.example.sp22_bse_6a_demo.basics.Name

data class Person(
    var name: Name? = null,
    var age: Int? = null,
    var email: String? = null
) {

//    companion object {
        fun getPersonsName(personsList: List<Person>): List<String> {
            return personsList.map { person: Person ->
                person.name?.firstName?:""
            }

        }
//    }

    override fun toString(): String {
        return "Person(nam=$name, age=$age, email=$email)\n"
    }
}