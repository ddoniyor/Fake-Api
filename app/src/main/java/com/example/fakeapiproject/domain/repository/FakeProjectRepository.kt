package com.example.fakeapiproject.domain.repository

import com.example.fakeapiproject.data.remote.dto.PhotoDto
import com.example.fakeapiproject.data.remote.dto.PostDto
import com.example.fakeapiproject.domain.model.Post

interface FakeProjectRepository {

    suspend fun getPhotos():List<PhotoDto>
    suspend fun getPhotoById(photoId:Int):PhotoDto
    suspend fun getPosts(): List<PostDto>
}