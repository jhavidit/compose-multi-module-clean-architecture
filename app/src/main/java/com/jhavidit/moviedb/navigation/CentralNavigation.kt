package com.jhavidit.moviedb.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.jhavidit.home.homeNavGraph
import com.jhavidit.moviedb.bottomnav.BottomScreens
import com.jhavidit.profile.profileNavGraph
import com.jhavidit.search.searchNavGraph

@Composable
fun CentralNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomScreens.Home.route){
        homeNavGraph(navController)
        searchNavGraph(navController)
        profileNavGraph(navController)
    }

}