package com.mytrainingprogress.auth.data.mapper

import com.google.firebase.auth.FirebaseUser
import com.mytrainingprogress.common.domain.model.User

fun FirebaseUser.toDomain(): User {
    return User(
        uid = uid,
        email = email,
        displayName = displayName,
        photoUrl = photoUrl,
        phoneNumber = phoneNumber,
        createdAt = this.metadata?.creationTimestamp,
        isEmailVerified = isEmailVerified
    )
}

