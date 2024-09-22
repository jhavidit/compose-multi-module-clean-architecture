package com.jhavidit.moviedb.bottomnav

import com.jhavidit.home.HomeGraph
import com.jhavidit.moviedb.R
import com.jhavidit.profile.ProfileGraph
import com.jhavidit.search.SearchGraph
import kotlinx.serialization.Serializable

@Serializable
sealed class BottomScreens<T>(
    val name: String,
    val selectedIcon: Int,
    val unselectedIcon: Int,
    val route: T
) {

    @Serializable
    data object Home : BottomScreens<HomeGraph>(
        name = "Home",
        unselectedIcon = R.drawable.home_unfilled,
        selectedIcon = R.drawable.home_filled,
        route = HomeGraph
    )

    @Serializable
    data object Search : BottomScreens<SearchGraph>(
        name = "Search",
        unselectedIcon = R.drawable.search_unfilled,
        selectedIcon = R.drawable.search_filled,
        route = SearchGraph
    )

    @Serializable
    data object Profile : BottomScreens<ProfileGraph>(
        name = "Profile",
        unselectedIcon = R.drawable.profile_unfilled,
        selectedIcon = R.drawable.profile_filled,
        route = ProfileGraph
    )

}