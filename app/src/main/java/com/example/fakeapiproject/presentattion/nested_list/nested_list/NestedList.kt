package com.example.fakeapiproject.presentattion.nested_list.nested_list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import com.example.fakeapiproject.presentattion.nested_list.nested_list.components.HorizontalItem
import com.example.fakeapiproject.presentattion.nested_list.nested_list.components.VerticalItem
import com.example.photo_presentation.Destinations
import com.example.photo_presentation.PhotoNavigationGraph
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState


@Composable
fun NestedList(
    navController: NavController,
    nestedViewModel: NestedListViewModel = hiltViewModel()
) {
    SwipeRefreshComposeNested(
        nestedViewModel = nestedViewModel,
        navController = navController
    )
}

@Composable
fun SwipeRefreshComposeNested(
    modifier: Modifier = Modifier,
    navController: NavController,
    nestedViewModel: NestedListViewModel
) {
    val state = nestedViewModel.state.value

    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing = state.isRefreshing),
        onRefresh = { nestedViewModel.getPostsAndPhotos()}) {

        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                item {
                    LazyRow(content = {
                        items(state.posts) { post ->
                            HorizontalItem(post = post) {
                                navController.navigate(Destinations.PhotoDetailScreen.screen_route + "/${it.id}")
                            }
                        }
                    })
                }
                items(state.photos) { photo ->
                    VerticalItem(
                        photo = photo,
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

