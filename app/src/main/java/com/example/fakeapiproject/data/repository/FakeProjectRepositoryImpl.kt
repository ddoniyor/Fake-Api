package com.example.fakeapiproject.data.repository

import com.example.fakeapiproject.data.local.db.AppDatabase
import com.example.fakeapiproject.data.local.model.PhotoEntity
import com.example.fakeapiproject.data.remote.api.FakeProjectApi
import com.example.fakeapiproject.data.remote.dto.PostDto
import com.example.fakeapiproject.domain.repository.FakeProjectRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FakeProjectRepositoryImpl @Inject constructor(
    private val api: FakeProjectApi,
    private val db: AppDatabase
) :FakeProjectRepository {


    override suspend fun getPostsApi(): List<PostDto> {
        return api.getPosts()
    }

    override suspend fun getPhotosDb(): Flow<List<PhotoEntity>> {
        return db.photoDao().getPhotos()
    }

    override suspend fun getPhotoByIdDb(id: Int): Flow<PhotoEntity> {
        return db.photoDao().getPhotoById(id)
    }

    override suspend fun addPhotoDb(photoEntity: PhotoEntity) {
        return db.photoDao().addPhoto(photoEntity)
    }

    override suspend fun deletePhoto(photo: PhotoEntity) {
        return db.photoDao().deletePhoto(photo)
    }

}