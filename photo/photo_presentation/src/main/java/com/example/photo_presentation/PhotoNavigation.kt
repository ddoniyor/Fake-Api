package com.example.photo_presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.core.PhotoConstants
import com.example.photo_presentation.photo_detail.PhotoDetailScreen
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

        composable(route = Destinations.PhotoDetailScreen.screen_route + "/{${PhotoConstants.PARAM_PHOTO_ID}}") {
            LaunchedEffect(Unit) {
                bottomBarState.value = false
            }
            PhotoDetailScreen()
        }

    }
}



sealed class Destinations(val screen_route: String) {
    object PhotoListScreen : Destinations("photo_list_screen")
    object PhotoDetailScreen : Destinations("photo_detail_screen")
    object Splash : Destinations("splash_screen")
}