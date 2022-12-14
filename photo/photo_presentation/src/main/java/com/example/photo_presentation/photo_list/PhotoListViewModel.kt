package com.example.photo_presentation.photo_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.PhotoResource
import com.example.photo_domain.get_photos.GetPhotosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PhotoListViewModel @Inject constructor(
    private val getPhotosUseCase: GetPhotosUseCase
):ViewModel() {

    private val _state = mutableStateOf(PhotoListState())
    val state: State<PhotoListState> = _state

    init {
        getPhotos()
    }

    fun getPhotos(isRefreshing :Boolean = false){
        getPhotosUseCase().onEach { result->
            when(result){
                is PhotoResource.Success->{
                    _state.value = PhotoListState(photos = result.data ?: emptyList())
                }
                is PhotoResource.Error->{
                    _state.value = PhotoListState(error = result.message ?: "Unexpected error occurred")
                }
                is PhotoResource.Loading->{
                    if (isRefreshing) {
                        _state.value = PhotoListState(isRefreshing = true)
                    } else {
                        _state.value = PhotoListState(isLoading = true)
                    }
                }
            }

        }.launchIn(viewModelScope)
    }

}