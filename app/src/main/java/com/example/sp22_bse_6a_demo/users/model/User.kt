package com.example.sp22_bse_6a_demo.users.model

data class User(
    val name: String? = "",
    val age: Int? = 0,
    val gender: Gender
)

enum class Gender {
    MALE,
    FEMALE
}