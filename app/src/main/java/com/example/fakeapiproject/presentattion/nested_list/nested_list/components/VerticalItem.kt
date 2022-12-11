package com.example.fakeapiproject.presentattion.nested_list.nested_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.photo_domain.Photo
import com.skydoves.landscapist.glide.GlideImage


@Composable
fun VerticalItem(
    photo: Photo,
    onItemClick: (Photo) -> Unit
){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clickable { onItemClick(photo) },
        elevation = 10.dp,
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp, top = 10.dp, bottom = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = "${photo.id}. ${photo.title} ",
                style = MaterialTheme.typography.h6,
                modifier = Modifier
                    .weight(8f)
                    .padding(start = 0.dp, end = 5.dp, top = 0.dp, bottom = 0.dp)
            )
            GlideImage(
                imageModel ="https://picsum.photos/200/300",
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center
            )
        }
    }
}