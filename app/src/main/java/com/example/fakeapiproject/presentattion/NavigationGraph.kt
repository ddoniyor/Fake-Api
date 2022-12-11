package com.example.fakeapiproject.presentattion

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fakeapiproject.common.Constants
import com.example.photo_presentation.PhotoNavigationGraph

@Composable
fun NavigationGraph(navController: NavHostController,bottomBarState:MutableState<Boolean>) {
    val photoNavController = rememberNavController()
    NavHost(navController, startDestination = BottomNavItem.CommonList.screen_route) {
        composable(BottomNavItem.CommonList.screen_route) {
            LaunchedEffect(Unit) {
                bottomBarState.value = true
            }
            PhotoNavigationGraph(bottomBarState = bottomBarState, navController = photoNavController)
        }
        composable(BottomNavItem.NestedList.screen_route) {
            LaunchedEffect(Unit) {
                bottomBarState.value = true
            }
            NetworkScreen(navController,photoNavController)
        }
        composable(BottomNavItem.Grid.screen_route) {
            LaunchedEffect(Unit) {
                bottomBarState.value = true
            }
            AddPostScreen(navController)
        }
        composable(BottomNavItem.ListDb.screen_route) {
            LaunchedEffect(Unit) {
                bottomBarState.value = true
            }
            NotificationScreen(navController)
        }
        composable(BottomNavItem.Jobs.screen_route) {
            LaunchedEffect(Unit) {
                bottomBarState.value = true
            }
            JobScreen()
        }

    }
}