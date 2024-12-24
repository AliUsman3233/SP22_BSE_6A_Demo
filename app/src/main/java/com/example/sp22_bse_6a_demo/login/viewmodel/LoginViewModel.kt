package com.example.sp22_bse_6a_demo.person.viewmodel

import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sp22_bse_6a_demo.login.model.LoginModel
import com.example.sp22_bse_6a_demo.login.repository.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    val authRepository: AuthRepository,
) : ViewModel() {  // MMVM Android Kotlin
//    val person: PersonModel = PersonModel()

    val loginModelMLD: MutableLiveData<LoginModel> = MutableLiveData(
        LoginModel(
            userName = "Anwar",
            email = "anwar@gmail.com",
            password = "654321"
        )
    )

//    val firebaseAuth:FirebaseAuth = FirebaseAuth.getInstance()
//    val fireStoreDb = Firebase.firestore
//    var context: Context? = null

    //    fun initContext(context: Context) {
//        this@LoginViewModel.context = context;
//    }
    fun login() {
        viewModelScope.launch(Dispatchers.IO) {
            authRepository.login(loginModelMLD.value ?: LoginModel())
        }
//        Log.e("LoginViewModel", "login: loginModelMLD -> ${loginModelMLD.value}", )
//        firebaseAuth.signInWithEmailAndPassword(loginModelMLD.value?.email?:"", loginModelMLD.value?.password?:"").addOnSuccessListener { successState->
//            Log.e("LoginViewModel", "login state: Successful", )
//            Toast.makeText(context, successState.user?.email + " Logged in successfully",Toast.LENGTH_LONG).show()
//
//        }.addOnFailureListener { failedState ->
//            Log.e("LoginViewModel", "login state: Failed", )
//            Log.e("LoginViewModel", "login state message: Failed ${failedState.message}", )
//            Toast.makeText(context, failedState.message,Toast.LENGTH_LONG).show()
//        }
    }

    fun signUp() {
        viewModelScope.launch(Dispatchers.IO) {
            authRepository.signup(loginModelMLD.value ?: LoginModel())
        }
//        firebaseAuth.createUserWithEmailAndPassword(loginModelMLD.value?.email?:"", loginModelMLD.value?.password?:"").addOnSuccessListener {
//            Toast.makeText(context, "User Created Successfully",Toast.LENGTH_LONG).show()
//            storeUserData()
//        }.addOnFailureListener { result->
//            Toast.makeText(context, result.message,Toast.LENGTH_LONG).show()
//        }
    }

//    fun storeUserData() {
//        fireStoreDb.collection("users").document(loginModelMLD.value?.email?:"dummy").set(loginModelMLD.value?:LoginModel()).addOnSuccessListener { successState ->
//            Toast.makeText(context, "Data against " + loginModelMLD.value?.email + " is stored successfully",Toast.LENGTH_LONG).show()
//        }.addOnFailureListener { result ->
//            Toast.makeText(context, result.message,Toast.LENGTH_LONG).show()
//        }
//    }


}