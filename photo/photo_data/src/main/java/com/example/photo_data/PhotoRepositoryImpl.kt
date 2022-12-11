package com.example.photo_data

import com.example.photo_domain.Photo
import com.example.photo_domain.PhotoRepository
import javax.inject.Inject

class PhotoRepositoryImpl @Inject constructor(
    private val api: PhotosApi
) : PhotoRepository{

    override suspend fun getPhotosApi(): List<Photo> {
        return api.getPhotos()
    }

    override suspend fun getPhotoByIdApi(photoId: Int): Photo {
        return api.getPhotoById(photoId)
    }
}