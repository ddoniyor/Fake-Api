package com.example.fakeapiproject.presentattion.grid.posts_grid_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fakeapiproject.common.Resource
import com.example.fakeapiproject.domain.use_case.get_posts.GetPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class GridListViewModel @Inject constructor(
    private val getPostsUseCase: GetPostsUseCase
): ViewModel() {

    private val _state = mutableStateOf(GridListState())
    val state: State<GridListState> = _state

    init {
        getPosts()
    }
    fun getPosts(isRefreshing: Boolean = false){
        getPostsUseCase().onEach { result->
            when (result) {
                is Resource.Success -> {
                    _state.value = GridListState(
                        posts = result.data?: emptyList()
                    )
                }
                is Resource.Error -> {
                    _state.value =
                        GridListState(error = result.message ?: "Unexpected error occurred")
                }
                is Resource.Loading -> {
                    if (isRefreshing) {
                        _state.value = GridListState(isRefreshing = true)
                    } else {
                        _state.value = GridListState(isLoading = true)
                    }
                }
            }
        }.launchIn(viewModelScope)
    }

}