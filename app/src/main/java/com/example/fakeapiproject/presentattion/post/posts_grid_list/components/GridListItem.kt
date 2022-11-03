package com.example.fakeapiproject.presentattion.post.posts_grid_list.components

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
import androidx.compose.ui.unit.sp
import com.example.fakeapiproject.domain.model.Photo
import com.example.fakeapiproject.domain.model.Post
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun GridListItem(
    post: Post,
    onItemClick: (Post) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable { onItemClick(post) },
        elevation = 10.dp,
        shape = RoundedCornerShape(30.dp)
    ) {
        Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "${post.id}",
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(start = 15.dp, end = 15.dp, top = 15.dp, bottom = 15.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            GlideImage(
                imageModel ="https://images.unsplash.com/photo-1638486071992-536e48c8fa3e?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NXx8bG9vayUyMGJhY2t8ZW58MHx8MHx8&w=1000&q=80",
                modifier = Modifier
                    .height(150.dp)
                    .width(150.dp)
                    .clip(RoundedCornerShape(10.dp)).padding(0.dp),
                contentScale = ContentScale.Crop
            )

        }

    }
}
