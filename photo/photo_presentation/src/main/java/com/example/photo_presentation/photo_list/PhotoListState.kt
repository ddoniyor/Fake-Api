package com.example.photo_presentation.photo_list

import com.example.photo_domain.Photo


data class PhotoListState(
    val isLoading:Boolean =false,
    val isRefreshing:Boolean = false,
    val photos:List<Photo> = emptyList(),
    val error:String = ""
)
