package com.example.sp22_bse_6a_demo.login.repository

import android.util.Log
import android.widget.Toast
import com.example.sp22_bse_6a_demo.MyApplication
import com.example.sp22_bse_6a_demo.login.model.LoginModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    val firebaseAuth: FirebaseAuth,
    val firebaseFireStoreInstance: FirebaseFirestore
) : AuthRepository {

    override suspend fun login(loginModel: LoginModel, responseCallBack: (AuthResponse) -> Unit) {
        firebaseAuth.signInWithEmailAndPassword(loginModel.email ?: "", loginModel.password ?: "")
            .addOnSuccessListener { successState ->
                CoroutineScope(Dispatchers.IO).launch {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(
                            MyApplication.context,
                            successState.user?.email + " Logged in successfully",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
                responseCallBack.invoke(AuthResponse(ResponseState.SUCCESS, "Login Successful"))
            }.addOnFailureListener { failedState ->
                CoroutineScope(Dispatchers.IO).launch {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(
                            MyApplication.context,
                            failedState.message,
                            Toast.LENGTH_LONG
                        )
                            .show()
                    }
                    responseCallBack.invoke(AuthResponse(ResponseState.ERROR, failedState.message ?: ""))
                }
            }
    }

    override suspend fun signup(loginModel: LoginModel, responseCallBack: (AuthResponse) -> Unit) {
        firebaseAuth.createUserWithEmailAndPassword(
            loginModel.email ?: "",
            loginModel.password ?: ""
        ).addOnSuccessListener {
            CoroutineScope(Dispatchers.IO).launch {
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                        MyApplication.context,
                        "User Created Successfully",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
            responseCallBack.invoke(AuthResponse(ResponseState.SUCCESS, "User Created Successfully"))
            storeUserData(loginModel, responseCallBack)
        }.addOnFailureListener { result ->
            CoroutineScope(Dispatchers.IO).launch {
                withContext(Dispatchers.Main) {
                    Toast.makeText(MyApplication.context, result.message, Toast.LENGTH_LONG).show()
                }
            }
            responseCallBack.invoke(AuthResponse(ResponseState.ERROR, result.message ?: ""))

        }
    }

    private fun storeUserData(loginModel: LoginModel, responseCallBack: (AuthResponse) -> Unit) {
        firebaseFireStoreInstance.collection("users").document(loginModel.email ?: "dummy")
            .set(loginModel).addOnSuccessListener { successState ->
                CoroutineScope(Dispatchers.IO).launch {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(
                            MyApplication.context,
                            "Data against " + loginModel.email + " is stored successfully",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
                responseCallBack.invoke(
                    AuthResponse(
                        ResponseState.SUCCESS,
                        "Data against \" + loginModel.email + \" is stored successfully"
                    )
                )

            }.addOnFailureListener { result ->
                CoroutineScope(Dispatchers.IO).launch {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(MyApplication.context, result.message, Toast.LENGTH_LONG)
                            .show()
                    }
                }
                responseCallBack.invoke(AuthResponse(ResponseState.ERROR, result.message ?: ""))

            }
    }


}