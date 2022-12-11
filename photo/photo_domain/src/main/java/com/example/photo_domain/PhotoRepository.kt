package com.example.photo_domain

interface PhotoRepository {

    suspend fun getPhotosApi():List<Photo>

    suspend fun getPhotoByIdApi(photoId:Int):Photo
}