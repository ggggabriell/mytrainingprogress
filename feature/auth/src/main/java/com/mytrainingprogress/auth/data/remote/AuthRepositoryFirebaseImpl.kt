package com.mytrainingprogress.auth.data.remote

import com.mytrainingprogress.auth.data.mapper.toDomain
import com.mytrainingprogress.auth.data.remote.source.FirebaseAuthDataSource
import com.mytrainingprogress.auth.domain.repository.AuthRepository
import com.mytrainingprogress.common.domain.model.User

/**
 * Implementation of [AuthRepository] that uses Firebase Authentication.
 */
class AuthRepositoryFirebaseImpl(
    private val firebaseDataSource: FirebaseAuthDataSource
) : AuthRepository {

    override suspend fun login(email: String, password: String): Result<User?> {
        return runCatching {
            firebaseDataSource.signIn(email, password).toDomain()
        }
    }

    override suspend fun register(email: String, password: String): Result<User?> {
        return runCatching {
            firebaseDataSource.register(email, password).toDomain()
        }
    }

    override fun logout() {
        firebaseDataSource.logout()
    }

    override fun isUserLoggedIn(): Boolean {
        return firebaseDataSource.isLoggedIn()
    }

    override fun getCurrentUser(): User? {
        return firebaseDataSource.currentUser()?.toDomain()
    }
}