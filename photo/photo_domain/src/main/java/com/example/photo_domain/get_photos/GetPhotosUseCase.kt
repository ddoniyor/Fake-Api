package com.example.photo_domain.get_photos

import com.example.photo_domain.Photo
import com.example.core.ApiLogger
import com.example.photo_domain.PhotoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException


import javax.inject.Inject

class GetPhotosUseCase @Inject constructor(
    private val repository: PhotoRepository
) {
    private val TAG = "GetPhotosUseCase"
    operator fun invoke() : Flow<com.example.core.PhotoResource<List<Photo>>> = flow{
        try {
            emit(com.example.core.PhotoResource.Loading<List<Photo>>())
            val photos = repository.getPhotosApi().map {it}
            emit(com.example.core.PhotoResource.Success<List<Photo>>(photos))
            ApiLogger.isSuccess(TAG,"${photos[0]}")
        }catch (e: HttpException){
            emit(com.example.core.PhotoResource.Error<List<Photo>>(e.localizedMessage?:"An unexpected error occurred."))
            ApiLogger.isUnSuccess(TAG, e.localizedMessage?:"An unexpected error occurred.")
        }catch (e: IOException){
            emit(com.example.core.PhotoResource.Error<List<Photo>>("Could not reach the server. Check internet connection."))
            ApiLogger.isFailure(TAG,"${e.message}")
        }
    }
}