package com.example.core


sealed class PhotoResource<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T) : PhotoResource<T>(data)
    class Error<T>(message: String, data: T? = null) : PhotoResource<T>(data, message)
    class Loading<T>(data: T? = null) : PhotoResource<T>(data)
}