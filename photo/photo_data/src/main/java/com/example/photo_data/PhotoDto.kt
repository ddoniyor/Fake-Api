package com.example.photo_data

import com.example.photo_domain.Photo

data class PhotoDto(
    val albumId: Int,
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