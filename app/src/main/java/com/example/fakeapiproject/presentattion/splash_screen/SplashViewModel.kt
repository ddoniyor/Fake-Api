package com.example.fakeapiproject.presentattion.splash_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.fakeapiproject.domain.use_case.get_photos.GetPhotosUseCase
import com.example.fakeapiproject.presentattion.photo_list.PhotoListState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

class SplashViewModel :ViewModel() {
    private val _state = mutableStateOf(SplashScreenState())
    val state: State<SplashScreenState> = _state

    fun setSplashState(state: Boolean){
        _state.value = SplashScreenState(state)
    }
}