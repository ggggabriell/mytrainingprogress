package com.mytrainingprogress.auth.di

import com.google.firebase.auth.FirebaseAuth
import com.mytrainingprogress.auth.data.remote.AuthRepositoryFirebaseImpl
import com.mytrainingprogress.auth.data.remote.source.FirebaseAuthDataSource
import com.mytrainingprogress.auth.domain.repository.AuthRepository
import org.koin.dsl.module

val authModule = module {
    single { FirebaseAuth.getInstance() }
    single { FirebaseAuthDataSource(get()) }
    single<AuthRepository> { AuthRepositoryFirebaseImpl(get()) }
}