package com.example.fakeapiproject.domain.repository

import com.example.fakeapiproject.data.remote.dto.PhotoDto

interface FakeProjectRepository {

    suspend fun getPhotos():List<PhotoDto>
    suspend fun getPhotoById(photoId:Int):PhotoDto

}