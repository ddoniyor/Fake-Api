package com.example.fakeapiproject.data.remote.dto

import com.example.fakeapiproject.domain.model.Post

data class PostDto(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)

fun PostDto.toPost():Post{
    return Post(
        id = id,
        title = title,
        body = body
    )
}