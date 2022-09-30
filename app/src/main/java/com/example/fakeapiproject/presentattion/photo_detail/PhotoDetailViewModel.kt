package com.example.fakeapiproject.presentattion.photo_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fakeapiproject.common.Constants
import com.example.fakeapiproject.common.Resource
import com.example.fakeapiproject.domain.use_case.get_photo.GetPhotoUseCase
import com.example.fakeapiproject.presentattion.photo_list.PhotoListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PhotoDetailViewModel @Inject constructor(
    private val getPhotoUseCase: GetPhotoUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(PhotoDetailState())
    val state: State<PhotoDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_PHOTO_ID)?.let { photoId ->
            getPhoto(photoId.toInt())
        }
    }

    private fun getPhoto(id: Int) {
        getPhotoUseCase(id).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = PhotoDetailState(photo = result.data)
                }
                is Resource.Error -> {
                    _state.value =
                        PhotoDetailState(error = result.message ?: "Unexpected error occurred")
                }
                is Resource.Loading -> {
                    _state.value = PhotoDetailState(isLoading = true)
                }
            }

        }.launchIn(viewModelScope)
    }
}