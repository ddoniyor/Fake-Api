package com.example.photo_data

import com.example.photo_domain.Photo
import retrofit2.http.GET
import retrofit2.http.Path

interface PhotosApi {

    @GET("/photos")
    suspend fun getPhotos():List<Photo>

    @GET("/photos/{photoId}")
    suspend fun getPhotoById(@Path("photoId") photoId : Int) : Photo
}