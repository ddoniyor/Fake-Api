package com.example.photo_data


interface PhotoRepository {

    suspend fun getPhotosApi():List<PhotoDto>

    suspend fun getPhotoByIdApi(photoId:Int): PhotoDto
}