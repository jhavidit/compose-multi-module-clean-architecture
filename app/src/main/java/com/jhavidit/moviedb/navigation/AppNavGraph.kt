package com.jhavidit.moviedb.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jhavidit.core.preferences.AppPreferences
import com.jhavidit.moviedb.MainScreen
import com.jhavidit.moviedb.login.LoginScreen

@Composable
fun AppNavGraph(navHostController: NavHostController, appPreferences: AppPreferences) {

    val isLoggedIn = appPreferences.getAuthToken().collectAsState(initial = null).value != null

    NavHost(
        navController = navHostController,
        startDestination = if (isLoggedIn) MainScreen else LoginScreen
    ) {
        composable<LoginScreen> {
            LoginScreen(
                onLoginSuccess = {
                    navHostController.navigate(MainScreen){
                        popUpTo(LoginScreen) { inclusive = true }
                    }
                }
            )
        }
        composable<MainScreen> {
           MainScreen()
        }
    }
}