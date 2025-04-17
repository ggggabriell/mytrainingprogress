package com.mytrainingprogress.auth.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mytrainingprogress.auth.ui.AuthScreen
import com.mytrainingprogress.auth.ui.login.LoginScreen
import com.mytrainingprogress.auth.ui.register.RegisterScreen

@Composable
fun AuthNavGraph(
    navController: NavHostController,
    onAuthSuccess: () -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = AuthScreen.Login.route
    ) {
        composable(AuthScreen.Login.route) {
            //LoginScreen()
        }
        composable(AuthScreen.Register.route) {
            RegisterScreen()
        }
    }
}