package com.example.fakeapiproject.presentattion.grid.posts_grid_list

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.fakeapiproject.presentattion.grid.posts_grid_list.components.GridListItem
import com.example.photo_presentation.Destinations
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun GridList(
    navController: NavController,
    gridListViewModel: GridListViewModel = hiltViewModel()
) {
    SwipeRefreshComposeNested(
        gridListViewModel = gridListViewModel,
        navController = navController
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SwipeRefreshComposeNested(
    modifier: Modifier = Modifier,
    navController: NavController,
    gridListViewModel: GridListViewModel
) {
    val state = gridListViewModel.state.value

    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing = state.isRefreshing),
        onRefresh = {gridListViewModel.getPosts(isRefreshing = true)}) {

        Box(modifier = Modifier.fillMaxSize()) {
            LazyVerticalGrid(modifier = Modifier.fillMaxSize(), columns = GridCells.Fixed(2)) {

                items(state.posts) { post ->
                    GridListItem(
                        post = post,
                        onItemClick = {
                            navController.navigate(Destinations.PhotoDetailScreen.screen_route + "/${it.id}")
                        }
                    )
                }
            }


            if (state.error.isNotBlank()) {
                Text(
                    text = state.error,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )
            }
            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }

        }
    }
}

