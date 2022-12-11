package com.example.photo_domain.get_photo


import com.example.photo_domain.Photo
import com.example.core.PhotoResource

import com.example.core.ApiLogger
import com.example.photo_domain.PhotoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException


import javax.inject.Inject

class GetPhotoUseCase @Inject constructor(
    private val repository: PhotoRepository
) {
    private val TAG = "GetPhotoUseCase"
    operator fun invoke(photoId:Int) : Flow<PhotoResource<Photo>> = flow{
        try {
            emit(PhotoResource.Loading<Photo>())
            val photo = repository.getPhotoByIdApi(photoId)
            emit(PhotoResource.Success<Photo>(photo))
            ApiLogger.isSuccess(TAG,photo)
        }catch (e: HttpException){
            emit(PhotoResource.Error<Photo>(e.localizedMessage?:"An unexpected error occurred."))
            ApiLogger.isUnSuccess(TAG, e.localizedMessage?:"An unexpected error occurred.")
        }catch (e: IOException){
            emit(PhotoResource.Error<Photo>("Could not reach the server. Check internet connection."))
            ApiLogger.isFailure(TAG,"${e.message}")
        }
    }
}