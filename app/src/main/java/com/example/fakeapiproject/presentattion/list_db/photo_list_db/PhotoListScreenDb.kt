package com.example.fakeapiproject.presentattion.list_db.photo_list_db

import android.util.Log
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
import com.example.fakeapiproject.presentattion.list_db.photo_list_db.components.PhotoListItemDb


@Composable
fun PhotoListScreenDb(
    navController: NavController,
    viewModelDb: PhotoListViewModelDb = hiltViewModel()
) {


    LaunchedEffect(Unit) {
        viewModelDb.getPhotos()
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        if (viewModelDb.statePhotos.isEmpty()){
            Text(
                text = "List is empty !!!",
                modifier = Modifier.padding(20.dp)
            )
        }
        LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(viewModelDb.statePhotos) { photo ->
                    PhotoListItemDb(
                        photo = photo,
                        onCardClick = {
                        },
                        onDeleteClick = {
                            viewModelDb.deletePhoto(photo)
                        }
                    )
                }
        }

    }
}
