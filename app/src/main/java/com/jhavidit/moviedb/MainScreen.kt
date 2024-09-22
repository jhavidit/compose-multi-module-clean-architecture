package com.jhavidit.moviedb

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.jhavidit.moviedb.bottomnav.AppBottomNavigation
import com.jhavidit.moviedb.navigation.CentralNavigation

@Composable
fun MainScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        val navController = rememberNavController()
        CentralNavigation(navController = navController)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .systemBarsPadding(),
            contentAlignment = Alignment.BottomCenter
        ) {
            AppBottomNavigation(navController = navController)
        }
    }
}