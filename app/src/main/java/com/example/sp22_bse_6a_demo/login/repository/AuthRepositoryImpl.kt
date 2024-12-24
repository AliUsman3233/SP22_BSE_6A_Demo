package com.example.sp22_bse_6a_demo.login.repository

import android.util.Log
import android.widget.Toast
import com.example.sp22_bse_6a_demo.MyApplication
import com.example.sp22_bse_6a_demo.login.model.LoginModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    val firebaseAuth: FirebaseAuth,
    val firebaseFireStoreInstance: FirebaseFirestore
): AuthRepository {
    override fun login(loginModel: LoginModel): AuthResponse {
        firebaseAuth.signInWithEmailAndPassword(loginModel.email?:"", loginModel.password?:"").addOnSuccessListener { successState->
            Toast.makeText(MyApplication.context, successState.user?.email + " Logged in successfully", Toast.LENGTH_LONG).show()
        }.addOnFailureListener { failedState ->
            Toast.makeText(MyApplication.context, failedState.message, Toast.LENGTH_LONG).show()
        }
        return AuthResponse(true, "")
    }

    override fun signup(loginModel: LoginModel): AuthResponse {
        firebaseAuth.createUserWithEmailAndPassword(loginModel.email?:"", loginModel.password?:"").addOnSuccessListener {
            Toast.makeText(MyApplication.context, "User Created Successfully",Toast.LENGTH_LONG).show()
            storeUserData(loginModel)
        }.addOnFailureListener { result->
            Toast.makeText(MyApplication.context, result.message,Toast.LENGTH_LONG).show()
        }
        return AuthResponse(true, "")
    }

    private fun storeUserData(loginModel: LoginModel) {
        firebaseFireStoreInstance.collection("users").document(loginModel.email?:"dummy").set(loginModel?: LoginModel()).addOnSuccessListener { successState ->
            Toast.makeText(MyApplication.context, "Data against " + loginModel.email + " is stored successfully",Toast.LENGTH_LONG).show()
        }.addOnFailureListener { result ->
            Toast.makeText(MyApplication.context, result.message,Toast.LENGTH_LONG).show()
        }
    }



}