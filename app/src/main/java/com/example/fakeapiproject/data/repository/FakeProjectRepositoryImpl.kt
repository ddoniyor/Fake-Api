package com.example.fakeapiproject.data.repository

import com.example.fakeapiproject.data.remote.api.FakeProjectApi
import com.example.fakeapiproject.data.remote.dto.PhotoDto
import com.example.fakeapiproject.data.remote.dto.PostDto
import com.example.fakeapiproject.domain.model.Post
import com.example.fakeapiproject.domain.repository.FakeProjectRepository
import javax.inject.Inject

class FakeProjectRepositoryImpl @Inject constructor(
    private val api: FakeProjectApi
) :FakeProjectRepository {
    override suspend fun getPhotos(): List<PhotoDto> {
        return api.getPhotos()
    }

    override suspend fun getPhotoById(photoId: Int): PhotoDto {
        return api.getPhotoById(photoId)
    }

    override suspend fun getPosts(): List<PostDto> {
        return api.getPosts()
    }

}