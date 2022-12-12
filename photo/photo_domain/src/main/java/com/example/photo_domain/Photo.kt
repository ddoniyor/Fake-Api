package com.example.photo_domain

import com.example.photo_data.PhotoDto

data class Photo(
    val id: Int,
    val thumbnailUrl: String,
    val title: String,
    val url: String
)
fun PhotoDto.toPhoto(): Photo {
    return Photo(
        id= id,
        thumbnailUrl = thumbnailUrl,
        title = title,
        url = url
    )
}