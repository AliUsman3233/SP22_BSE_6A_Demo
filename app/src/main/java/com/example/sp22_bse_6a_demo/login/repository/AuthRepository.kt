package com.example.sp22_bse_6a_demo.login.repository

import com.example.sp22_bse_6a_demo.login.model.LoginModel

interface AuthRepository {

    suspend fun login(
        loginModel: LoginModel,
        responseCallBack: (AuthResponse) -> Unit
    )

    suspend fun signup(
        loginModel: LoginModel,
        responseCallBack: (AuthResponse) -> Unit
    )
//    fun storeUserData(loginModel: LoginModel)
}


data class AuthResponse(
    val state: ResponseState?= ResponseState.DEFAULT,
    val message: String
) {
    fun getVisibilityState(): Boolean {
        return state != ResponseState.DEFAULT
    }
}

enum class ResponseState {
    DEFAULT,
    SUCCESS,
    ERROR
}