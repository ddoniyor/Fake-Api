package com.example.fakeapiproject.presentattion.post.posts_grid_list

import com.example.fakeapiproject.domain.model.Post

data class GridListState(
    val isLoading:Boolean =false,
    val isRefreshing:Boolean = false,
    val posts:List<Post> = emptyList(),
    val error:String = ""
)