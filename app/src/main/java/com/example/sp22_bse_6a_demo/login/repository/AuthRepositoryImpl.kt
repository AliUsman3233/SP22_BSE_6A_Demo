package com.example.sp22_bse_6a_demo.login.repository

class AuthRepositoryImpl: AuthRepository {
    override fun login(email: String, password: String): AuthResponse {
        return AuthResponse(true, "")
    }

    override fun signup(email: String, password: String): AuthResponse {
        return AuthResponse(true, "")
    }


}