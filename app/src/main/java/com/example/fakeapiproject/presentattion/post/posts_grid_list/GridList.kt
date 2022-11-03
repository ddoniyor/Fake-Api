package com.example.fakeapiproject.presentattion.post.posts_grid_list

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
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
import com.example.fakeapiproject.presentattion.Destinations
import com.example.fakeapiproject.presentattion.network.nested_list.NestedListViewModel
import com.example.fakeapiproject.presentattion.network.nested_list.components.HorizontalItem
import com.example.fakeapiproject.presentattion.network.nested_list.components.VerticalItem
import com.example.fakeapiproject.presentattion.post.posts_grid_list.components.GridListItem
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
            LazyVerticalGrid(modifier = Modifier.fillMaxSize(), cells =  GridCells.Fixed(2)) {

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

