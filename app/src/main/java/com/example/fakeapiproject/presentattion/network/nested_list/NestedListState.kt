package com.example.fakeapiproject.presentattion.network.nested_list

import com.example.fakeapiproject.domain.model.Photo
import com.example.fakeapiproject.domain.model.Post

data class NestedListState(
    val isLoading:Boolean =false,
    val isRefreshing:Boolean = false,
    val posts:List<Post> = emptyList(),
    val photos:List<Photo> = emptyList(),
    val error:String = ""
)
