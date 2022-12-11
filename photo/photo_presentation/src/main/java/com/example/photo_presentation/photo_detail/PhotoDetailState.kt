package com.example.photo_presentation.photo_detail


import com.example.photo_domain.Photo

data class PhotoDetailState(
    val isLoading:Boolean =false,
    val photo: Photo?=null,
    val error:String = ""
)
