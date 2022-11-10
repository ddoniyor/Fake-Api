package com.example.fakeapiproject.data.remote.dto

import com.example.fakeapiproject.data.local.model.PhotoEntity
import com.example.fakeapiproject.domain.model.Photo

data class PhotoDto(
    val albumId: Int,
    val id: Int,
    val thumbnailUrl: String,
    val title: String,
    val url: String
)

fun PhotoDto.toEntity():PhotoEntity{
    return PhotoEntity(
        id= id,
        thumbnailUrl = thumbnailUrl,
        title = title,
        url = url
    )
}

fun PhotoDto.toPhoto():Photo{
    return Photo(
        id= id,
        thumbnailUrl = thumbnailUrl,
        title = title,
        url = url
    )
}