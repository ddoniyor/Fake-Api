package com.example.fakeapiproject.domain.use_case.get_photos

import com.example.fakeapiproject.common.Resource
import com.example.fakeapiproject.data.remote.dto.toPhoto
import com.example.fakeapiproject.domain.model.Photo
import com.example.fakeapiproject.domain.repository.FakeProjectRepository
import com.example.fakeapiproject.utils.ApiLogger
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException


import javax.inject.Inject

class GetPhotosUseCase @Inject constructor(
    private val repository: FakeProjectRepository
) {
    private val TAG = "GetPhotosUseCase"
    operator fun invoke() : Flow<Resource<List<Photo>>> = flow{
        try {
            emit(Resource.Loading<List<Photo>>())
            val photos = repository.getPhotosApi().map {it.toPhoto()}
            emit(Resource.Success<List<Photo>>(photos))
            ApiLogger.isSuccess(TAG,"${photos[0]}")
        }catch (e: HttpException){
            emit(Resource.Error<List<Photo>>(e.localizedMessage?:"An unexpected error occurred."))
            ApiLogger.isUnSuccess(TAG, e.localizedMessage?:"An unexpected error occurred.")
        }catch (e: IOException){
            emit(Resource.Error<List<Photo>>("Could not reach the server. Check internet connection."))
            ApiLogger.isFailure(TAG,"${e.message}")
        }
    }
}