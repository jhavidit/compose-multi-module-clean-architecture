package com.jhavidit.search

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.searchNavGraph(navController: NavController){
    navigation<SearchGraph>(startDestination = SearchScreen){
        composable<SearchScreen> { SearchScreen() }
    }
}