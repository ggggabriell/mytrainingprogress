package com.mytrainingprogress.auth.data.remote.source

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

/**
 * Datasource class that handles authentication with Firebase Authentication.
 */
class FirebaseAuthDataSource(private val auth: FirebaseAuth) {

    suspend fun signIn(email: String, password: String): FirebaseUser {
        return suspendCancellableCoroutine { cont ->
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        cont.resume(task.result?.user ?: throw Exception("No user returned"))
                    } else {
                        cont.resumeWithException(task.exception ?: Exception("Login failed"))
                    }
                }
        }
    }

    suspend fun register(email: String, password: String): FirebaseUser {
        return suspendCancellableCoroutine { cont ->
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        cont.resume(task.result?.user ?: throw Exception("No user returned"))
                    } else {
                        cont.resumeWithException(task.exception ?: Exception("Registration failed"))
                    }
                }
        }
    }

    fun logout() {
        auth.signOut()
    }

    fun currentUser(): FirebaseUser? = auth.currentUser

    fun isLoggedIn(): Boolean = auth.currentUser != null
}