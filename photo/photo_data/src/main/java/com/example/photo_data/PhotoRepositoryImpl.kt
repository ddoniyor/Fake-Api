package com.example.photo_data

import javax.inject.Inject

class PhotoRepositoryImpl @Inject constructor(
    private val api: PhotosApi
) : PhotoRepository {

    override suspend fun getPhotosApi(): List<PhotoDto> {
        return api.getPhotos()
    }

    override suspend fun getPhotoByIdApi(photoId: Int): PhotoDto {
        return api.getPhotoById(photoId)
    }
}