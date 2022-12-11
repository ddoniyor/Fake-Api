package com.example.fakeapiproject.presentattion.nested_list.nested_list

import com.example.photo_domain.Photo
import com.example.fakeapiproject.domain.model.Post

data class NestedListState(
    val isLoading:Boolean =false,
    val isRefreshing:Boolean = false,
    val posts:List<Post> = emptyList(),
    val photos:List<Photo> = emptyList(),
    val error:String = ""
)
