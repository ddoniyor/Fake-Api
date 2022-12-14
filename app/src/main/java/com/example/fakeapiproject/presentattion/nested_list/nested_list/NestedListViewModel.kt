package com.example.fakeapiproject.presentattion.nested_list.nested_list

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fakeapiproject.common.Resource
import com.example.fakeapiproject.domain.use_case.get_posts_and_photos.GetPostsAndPhotosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class NestedListViewModel@Inject constructor(
    private val getPostsAndPhotosUseCase: GetPostsAndPhotosUseCase
): ViewModel()  {
    private val _state = mutableStateOf(NestedListState())
    val state: State<NestedListState> = _state


    init {
        getPostsAndPhotos()
    }

    fun getPostsAndPhotos(isRefreshing: Boolean = false) {
        getPostsAndPhotosUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = NestedListState(
                        posts = result.data?.posts ?: emptyList(),
                        photos = result.data?.photos ?: emptyList()
                    )
                    Log.d("NestedViewModel","${result.data?.photos} -- ${result.data?.photos}")
                }
                is Resource.Error -> {
                    _state.value =
                        NestedListState(error = result.message ?: "Unexpected error occurred")
                }
                is Resource.Loading -> {
                    if (isRefreshing) {
                        _state.value = NestedListState(isRefreshing = true)
                    } else {
                        _state.value = NestedListState(isLoading = true)
                    }

                }
            }

        }.launchIn(viewModelScope)
    }

}