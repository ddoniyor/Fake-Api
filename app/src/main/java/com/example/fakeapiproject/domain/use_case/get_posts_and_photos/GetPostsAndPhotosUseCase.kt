package com.example.fakeapiproject.domain.use_case.get_posts_and_photos

import com.example.fakeapiproject.common.Resource
import com.example.fakeapiproject.data.remote.dto.toPost
import com.example.fakeapiproject.domain.model.PostsAndPhotos
import com.example.fakeapiproject.domain.repository.FakeProjectRepository
import com.example.fakeapiproject.utils.ApiLogger
import com.example.photo_domain.PhotoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPostsAndPhotosUseCase @Inject constructor(
    private val repository: FakeProjectRepository,
    private val photoRepository: PhotoRepository
) {
    private val TAG = "GetPostsAndPhotosUseCase"

    operator fun invoke() : Flow<Resource<PostsAndPhotos>> = flow{
        try {
            emit(Resource.Loading<PostsAndPhotos>())
            val posts = repository.getPostsApi().map {it.toPost()}
            val photos = photoRepository.getPhotosApi()
            emit(Resource.Success<PostsAndPhotos>(PostsAndPhotos(posts = posts,photos = photos)))
            ApiLogger.isSuccess(TAG,"${posts[0]} ${photos[0]}")
        }catch (e: HttpException){
            emit(Resource.Error<PostsAndPhotos>(e.localizedMessage?:"An unexpected error occurred."))
            ApiLogger.isUnSuccess(TAG, e.localizedMessage?:"An unexpected error occurred.")
        }catch (e: IOException){
            emit(Resource.Error<PostsAndPhotos>("Could not reach the server. Check internet connection."))
            ApiLogger.isFailure(TAG,"${e.message}")
        }
    }
}