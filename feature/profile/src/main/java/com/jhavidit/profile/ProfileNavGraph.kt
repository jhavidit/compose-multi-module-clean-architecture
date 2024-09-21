package com.jhavidit.profile

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.profileNavGraph(navController: NavController){
    navigation<ProfileGraph>(startDestination = ProfileScreen){
        composable<ProfileScreen> { ProfileScreen() }
    }
}