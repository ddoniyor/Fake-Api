package com.example.fakeapiproject.presentattion.list_db.photo_list_db.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fakeapiproject.presentattion.ui.theme.FakeApiProjectTheme
import com.skydoves.landscapist.glide.GlideImage
import com.example.fakeapiproject.data.local.model.PhotoEntity

@Composable
fun PhotoListItemDb(
    photo: PhotoEntity,
    onCardClick: () -> Unit,
    onDeleteClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clickable { onCardClick() },
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
            IconButton(onClick = { onDeleteClick()}) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "delete_book",
                    tint = MaterialTheme.colors.onSurface,
                    modifier = Modifier.padding(20.dp)
                )
            }
            /*Image(
                painter = painterResource(id = R.drawable.ic_delete),
                contentDescription ="post",
                modifier = Modifier
                    .padding(20.dp)
                    .clickable {
                        onDeleteClick()
                    }
            )*/
        }
    }


}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PhotoListItemPreview() {
    FakeApiProjectTheme {

    }
}