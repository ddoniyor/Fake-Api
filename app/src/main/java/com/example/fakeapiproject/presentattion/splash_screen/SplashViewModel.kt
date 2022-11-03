package com.example.fakeapiproject.presentattion.splash_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SplashViewModel :ViewModel() {
    private val _state = mutableStateOf(SplashScreenState())
    val state: State<SplashScreenState> = _state

    fun setSplashState(state: Boolean){
        _state.value = SplashScreenState(state)
    }
}