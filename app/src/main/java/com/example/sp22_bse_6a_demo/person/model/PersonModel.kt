package com.example.sp22_bse_6a_demo.person.model

data class PersonModel(
    var name: String? = "",
    var email: String? = "",
    var age: String? = "",
    var address: String? = "", // 0 -> Male, 1-> Female
)
