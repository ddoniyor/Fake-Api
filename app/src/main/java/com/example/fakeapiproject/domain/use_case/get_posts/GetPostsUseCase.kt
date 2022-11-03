package com.example.fakeapiproject.domain.use_case.get_posts

import com.example.fakeapiproject.common.Resource
import com.example.fakeapiproject.data.remote.dto.toPhoto
import com.example.fakeapiproject.data.remote.dto.toPost
import com.example.fakeapiproject.domain.model.Photo
import com.example.fakeapiproject.domain.model.Post
import com.example.fakeapiproject.domain.repository.FakeProjectRepository
import com.example.fakeapiproject.utils.ApiLogger
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(
    private val repository: FakeProjectRepository
) {
    private val TAG = "GetPostsUseCase"

    operator fun invoke() : Flow<Resource<List<Post>>> = flow{
        try {
            emit(Resource.Loading<List<Post>>())
            val posts = repository.getPosts().map {it.toPost()}
            emit(Resource.Success<List<Post>>(posts))
            ApiLogger.isSuccess(TAG,posts)
        }catch (e: HttpException){
            emit(Resource.Error<List<Post>>(e.localizedMessage?:"An unexpected error occurred."))
            ApiLogger.isUnSuccess(TAG, e.localizedMessage?:"An unexpected error occurred.")
        }catch (e: IOException){
            emit(Resource.Error<List<Post>>("Could not reach the server. Check internet connection."))
            ApiLogger.isFailure(TAG,"${e.message}")
        }
    }
}