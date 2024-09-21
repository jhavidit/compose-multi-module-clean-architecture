package com.jhavidit.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.homeNavGraph(navController: NavController) {
    navigation<HomeGraph>(startDestination = HomeScreen) {
        composable<HomeScreen> { HomeScreen() }
    }
}