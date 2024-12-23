package com.example.sp22_bse_6a_demo.di

import com.example.sp22_bse_6a_demo.login.repository.AuthRepository
import com.example.sp22_bse_6a_demo.login.repository.AuthRepositoryImpl
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
    fun provideAuthRepository(): AuthRepository {
        return AuthRepositoryImpl()
    }
}
