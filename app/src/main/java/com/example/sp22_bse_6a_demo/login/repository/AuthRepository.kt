package com.example.sp22_bse_6a_demo.login.repository

import com.example.sp22_bse_6a_demo.login.model.LoginModel

interface AuthRepository {

    fun login(loginModel: LoginModel): AuthResponse
    fun signup(loginModel: LoginModel): AuthResponse
//    fun storeUserData(loginModel: LoginModel)
}


data class AuthResponse (
    val state: Boolean,
    val message: String
)