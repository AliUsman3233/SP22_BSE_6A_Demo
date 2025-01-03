package com.example.sp22_bse_6a_demo.di

import com.example.sp22_bse_6a_demo.login.repository.AuthRepository
import com.example.sp22_bse_6a_demo.login.repository.AuthRepositoryImpl
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryProvider {

    @ViewModelScoped
    @Provides
    fun provideAuthRepository(
        firebaseAuth: FirebaseAuth,
        firebaseFireStoreInstance: FirebaseFirestore
    ): AuthRepository {
        return AuthRepositoryImpl(
            firebaseAuth = firebaseAuth,
            firebaseFireStoreInstance = firebaseFireStoreInstance
        )
    }
}
