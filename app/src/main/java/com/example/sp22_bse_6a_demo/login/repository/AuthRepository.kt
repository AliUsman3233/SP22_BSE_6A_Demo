package com.example.sp22_bse_6a_demo.login.repository

interface AuthRepository {

    fun login(email: String, password: String): AuthResponse
    fun signup(email: String, password: String): AuthResponse
}


data class AuthResponse (
    val state: Boolean,
    val message: String
)