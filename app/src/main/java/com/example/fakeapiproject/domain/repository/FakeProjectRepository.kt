package com.example.fakeapiproject.domain.repository

import com.example.fakeapiproject.data.local.model.PhotoEntity

import com.example.fakeapiproject.data.remote.dto.PostDto

import kotlinx.coroutines.flow.Flow

interface FakeProjectRepository {


    suspend fun getPostsApi(): List<PostDto>

    suspend fun getPhotosDb():Flow<List<PhotoEntity>>
    suspend fun getPhotoByIdDb(id:Int):Flow<PhotoEntity>
    suspend fun addPhotoDb(photoEntity: PhotoEntity)
    suspend fun deletePhoto(photoEntity: PhotoEntity)
}