package com.mytrainingprogress.auth.domain.repository

import com.mytrainingprogress.common.domain.model.User

interface AuthRepository {
    suspend fun login(email: String, password: String): Result<User?>
    suspend fun register(email: String, password: String): Result<User?>
    fun logout()
    fun isUserLoggedIn(): Boolean
    fun getCurrentUser(): User?
}