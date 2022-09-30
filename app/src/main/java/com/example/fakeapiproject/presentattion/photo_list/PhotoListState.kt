package com.example.fakeapiproject.presentattion.photo_list

import com.example.fakeapiproject.domain.model.Photo

data class PhotoListState(
    val isLoading:Boolean =false,
    val photos:List<Photo> = emptyList(),
    val error:String = ""
)
