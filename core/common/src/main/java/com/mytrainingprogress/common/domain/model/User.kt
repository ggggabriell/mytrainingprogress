package com.mytrainingprogress.common.domain.model

data class User(
    val uid: String,
    val email: String,
    val displayName: String,
    val photoUrl: String? = null,
    val phoneNumber: String? = null,
    val createdAt: Long = System.currentTimeMillis(),
    val isEmailVerified: Boolean = false
)
