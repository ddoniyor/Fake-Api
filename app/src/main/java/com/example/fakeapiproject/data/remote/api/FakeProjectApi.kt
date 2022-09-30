package com.example.fakeapiproject.data.remote.api

import com.example.fakeapiproject.data.remote.dto.PhotoDto
import retrofit2.http.GET
import retrofit2.http.Path

interface FakeProjectApi {
    @GET("/photos")
    suspend fun getPhotos():List<PhotoDto>

    @GET("/photos/{photoId}")
    suspend fun getPhotoById(@Path("photoId") photoId : Int) : PhotoDto
}