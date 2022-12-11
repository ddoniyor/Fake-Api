package com.example.fakeapiproject.data.remote.api


import com.example.fakeapiproject.data.remote.dto.PostDto
import retrofit2.http.GET

interface FakeProjectApi {


    @GET("/posts")
    suspend fun getPosts():List<PostDto>
}