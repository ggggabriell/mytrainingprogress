package com.mytrainingprogress.auth.ui

sealed class AuthScreen(val route: String) {
    data object Login : AuthScreen("auth/login")
    data object Register : AuthScreen("auth/register")
    data object ForgotPassword : AuthScreen("auth/forgot_password")
}