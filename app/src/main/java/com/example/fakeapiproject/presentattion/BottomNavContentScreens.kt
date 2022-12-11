package com.example.fakeapiproject.presentattion

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fakeapiproject.R
import com.example.fakeapiproject.presentattion.nested_list.nested_list.NestedList
import com.example.fakeapiproject.presentattion.grid.posts_grid_list.GridList
import com.example.fakeapiproject.presentattion.list_db.photo_list_db.PhotoListScreenDb
import com.example.photo_presentation.PhotoNavigationGraph


@Composable
fun NetworkScreen(
    navController: NavController,
    photoNavController:NavController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        NestedList(navController,photoNavController)
    }
}


@Composable
fun AddPostScreen(
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        GridList(navController)
    }
}


@Composable
fun NotificationScreen(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        PhotoListScreenDb(navController)
    }
}


@Composable
fun JobScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.teal_700))
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Jobs Screen",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 20.sp
        )
    }
}