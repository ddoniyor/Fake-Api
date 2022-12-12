package com.example.photo_presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.photo_presentation.photo_list.PhotoListScreen

@Composable
fun PhotoNavigationGraph(
    startDestination: String = Destinations.PhotoListScreen.screen_route,
    bottomBarState: MutableState<Boolean>,
    navController: NavHostController
) {

    NavHost(navController = navController, startDestination = startDestination) {

        composable(route = Destinations.PhotoListScreen.screen_route) {
            LaunchedEffect(Unit) {
                bottomBarState.value = true
            }
            PhotoListScreen(navController)
        }



    }
}



sealed class Destinations(val screen_route: String) {
    object PhotoListScreen : Destinations("photo_list_screen")
    object PhotoDetailScreen : Destinations("photo_detail_screen")
    object Splash : Destinations("splash_screen")
}