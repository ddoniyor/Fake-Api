package com.example.fakeapiproject.presentattion

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.fakeapiproject.R
import com.example.fakeapiproject.presentattion.photo_detail.PhotoDetailScreen
import com.example.fakeapiproject.presentattion.splash_screen.SplashScreen
import com.example.fakeapiproject.presentattion.splash_screen.SplashViewModel

@Composable
fun MainScreenView(viewModel: SplashViewModel = hiltViewModel()){
    val navController = rememberNavController()
    val bottomBarState = rememberSaveable { (mutableStateOf(true)) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    when (navBackStackEntry?.destination?.route) {
        Destinations.PhotoDetailScreen.screen_route -> {
            bottomBarState.value = false
        }
    }

    if(viewModel.state.value.isLoading){
        SplashScreen()
    }else{
        Scaffold(
            topBar = { TopAppBar(navController = navController)},
            bottomBar = {CustomBottomNavigation(navController = navController,bottomBarState) }
        ) {
            NavigationGraph(navController = navController,bottomBarState=bottomBarState)
        }
    }

}

@Composable
fun TopAppBar(navController: NavController) {
    TopAppBar(
        title = {
            Text(text = "Fake Api")
        },
        navigationIcon = if (navController.previousBackStackEntry != null) {
            {
                IconButton(onClick = {navController.navigateUp()}) {
                    Icon(Icons.Filled.ArrowBack, "backIcon")
                }
            }
        } else {
            null
        },
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = Color.White,
        elevation = 10.dp
    )
}


@Composable
fun CustomBottomNavigation(navController: NavController,bottomBarState: MutableState<Boolean>) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.MyNetwork,
        BottomNavItem.AddPost,
        BottomNavItem.Notification,
        BottomNavItem.Jobs
    )
    AnimatedVisibility(
        visible = bottomBarState.value,
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it }),
        content = {
            BottomNavigation(
                backgroundColor = colorResource(id = R.color.white),
                contentColor = Color.Black
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                items.forEach { item ->
                    BottomNavigationItem(
                        icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                        label = { Text(text = item.title,
                            fontSize = 9.sp) },
                        selectedContentColor = Color.Black,
                        unselectedContentColor = Color.Black.copy(0.4f),
                        alwaysShowLabel = true,
                        selected = currentRoute == item.screen_route,
                        onClick = {
                            navController.navigate(item.screen_route) {

                                navController.graph.startDestinationRoute?.let { screen_route ->
                                    popUpTo(screen_route) {
                                        saveState = true
                                    }
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        })

}