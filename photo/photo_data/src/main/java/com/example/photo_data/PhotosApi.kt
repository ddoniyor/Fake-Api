package com.example.photo_data

import retrofit2.http.GET
import retrofit2.http.Path

interface PhotosApi {

    @GET("/photos")
    suspend fun getPhotos():List<PhotoDto>

    @GET("/photos/{photoId}")
    suspend fun getPhotoById(@Path("photoId") photoId : Int) : PhotoDto
}