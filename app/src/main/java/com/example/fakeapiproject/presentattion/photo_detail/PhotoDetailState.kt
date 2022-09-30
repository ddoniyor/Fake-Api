package com.example.fakeapiproject.presentattion.photo_detail

import com.example.fakeapiproject.domain.model.Photo

data class PhotoDetailState(
    val isLoading:Boolean =false,
    val photo:Photo?=null,
    val error:String = ""
)