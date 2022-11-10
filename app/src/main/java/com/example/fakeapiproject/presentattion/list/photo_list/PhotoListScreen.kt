package com.example.fakeapiproject.presentattion.list.photo_list

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.fakeapiproject.data.local.model.PhotoEntity
import com.example.fakeapiproject.domain.model.Photo
import com.example.fakeapiproject.presentattion.Destinations
import com.example.fakeapiproject.presentattion.list.photo_list.components.PhotoListItem
import com.example.fakeapiproject.presentattion.list_db.photo_list_db.PhotoListViewModelDb
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun PhotoListScreen(
    navController: NavController,
    viewModel: PhotoListViewModel = hiltViewModel(),
    viewModelDb: PhotoListViewModelDb = hiltViewModel()
) {
    SwipeRefreshCompose(viewModel = viewModel, navController = navController, viewModelDb = viewModelDb)
}

@Composable
fun SwipeRefreshCompose(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: PhotoListViewModel,
    viewModelDb: PhotoListViewModelDb
) {
    val state = viewModel.state.value
    val localContext = LocalContext.current

    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing = state.isRefreshing),
        onRefresh = {viewModel.getPhotos(isRefreshing = true)}) {

        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.photos) { photo ->
                    PhotoListItem(photo = photo,
                        onCardClick = {
                            navController.navigate(Destinations.PhotoDetailScreen.screen_route + "/${photo.id}")
                        },
                        onAddClick = {
                            val response = viewModelDb.addPhoto(
                                PhotoEntity(
                                    id = photo.id,
                                    thumbnailUrl = photo.thumbnailUrl,
                                    title = photo.title,
                                    url = photo.url
                                )
                            )
                            Toast.makeText(localContext,"$response",Toast.LENGTH_SHORT).show()
                        }
                    )
                }
            }
            if (state.error.isNotBlank())  {
                Text(text = state.error,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )
            }
            if (state.isLoading){
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}