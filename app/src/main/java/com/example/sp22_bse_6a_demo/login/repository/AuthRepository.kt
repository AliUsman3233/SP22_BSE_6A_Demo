package com.example.sp22_bse_6a_demo.login.repository

interface AuthRepository {

    fun login(email: String, password: String): Unit
    fun signup(email: String, password: String): Unit
}