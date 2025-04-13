package com.mytrainingprogress.common.domain.model

import android.net.Uri

data class User(
    val uid: String = "",
    val email: String? = null,
    val displayName: String? = null,
    val photoUrl: Uri? = null,
    val phoneNumber: String? = null,
    val createdAt: Long? = System.currentTimeMillis(),
    val isEmailVerified: Boolean = false
)
