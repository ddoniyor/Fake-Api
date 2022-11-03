package com.example.fakeapiproject.presentattion

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.fakeapiproject.common.Constants
import com.example.fakeapiproject.presentattion.home.photo_detail.PhotoDetailScreen

@Composable
fun NavigationGraph(navController: NavHostController,bottomBarState:MutableState<Boolean>) {
    NavHost(navController, startDestination = BottomNavItem.Home.screen_route) {
        composable(BottomNavItem.Home.screen_route) {
            LaunchedEffect(Unit) {
                bottomBarState.value = true
            }
            HomeScreen(navController)
        }
        composable(BottomNavItem.MyNetwork.screen_route) {
            LaunchedEffect(Unit) {
                bottomBarState.value = true
            }
            NetworkScreen(navController)
        }
        composable(BottomNavItem.AddPost.screen_route) {
            LaunchedEffect(Unit) {
                bottomBarState.value = true
            }
            AddPostScreen(navController)
        }
        composable(BottomNavItem.Notification.screen_route) {
            LaunchedEffect(Unit) {
                bottomBarState.value = true
            }
            NotificationScreen()
        }
        composable(BottomNavItem.Jobs.screen_route) {
            LaunchedEffect(Unit) {
                bottomBarState.value = true
            }
            JobScreen()
        }
        composable(route = Destinations.PhotoDetailScreen.screen_route + "/{${Constants.PARAM_PHOTO_ID}}") {
            LaunchedEffect(Unit) {
                bottomBarState.value = false
            }
            PhotoDetailScreen()
        }
    }
}