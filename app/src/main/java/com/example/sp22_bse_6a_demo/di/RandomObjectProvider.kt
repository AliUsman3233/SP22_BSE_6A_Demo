package com.example.sp22_bse_6a_demo.di

import com.example.sp22_bse_6a_demo.login.repository.AuthRepository
import com.example.sp22_bse_6a_demo.login.repository.AuthRepositoryImpl
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class RandomObjectProvider {

    @ViewModelScoped
    @Provides
    fun provideFirebaseAuth(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }

    @ViewModelScoped
    @Provides
    fun provideFirebaseFireStore(): FirebaseFirestore {
        return Firebase.firestore
    }
}

