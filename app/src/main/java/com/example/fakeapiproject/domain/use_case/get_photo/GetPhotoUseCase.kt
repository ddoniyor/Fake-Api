package com.example.fakeapiproject.domain.use_case.get_photo

import com.example.fakeapiproject.common.Resource
import com.example.fakeapiproject.data.remote.dto.toPhoto
import com.example.fakeapiproject.domain.model.Photo
import com.example.fakeapiproject.domain.repository.FakeProjectRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException


import javax.inject.Inject

class GetPhotoUseCase @Inject constructor(
    private val repository: FakeProjectRepository
) {
    operator fun invoke(photoId:Int) : Flow<Resource<Photo>> = flow{
        try {
            emit(Resource.Loading<Photo>())
            val photos = repository.getPhotoById(photoId).toPhoto()
            emit(Resource.Success<Photo>(photos))
        }catch (e: HttpException){
            emit(Resource.Error<Photo>(e.localizedMessage?:"An unexpected error occurred."))
        }catch (e: IOException){
            emit(Resource.Error<Photo>("Could not reach the server. Check internet connection."))
        }
    }
}