package com.example.fakeapiproject.presentattion.list_db.photo_list_db

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fakeapiproject.data.local.model.PhotoEntity
import com.example.fakeapiproject.domain.repository.FakeProjectRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotoListViewModelDb @Inject constructor(
    private val repository: FakeProjectRepository
):ViewModel() {

    var statePhotos by mutableStateOf(emptyList<PhotoEntity>())
    var statePhoto by mutableStateOf(PhotoEntity(0,"","",""))


    fun getPhotos(){
        viewModelScope.launch {
            try {
                repository.getPhotosDb().collect { value ->
                    statePhotos = value
                    println("Received ${value[0]}")
                }
            } catch (e: Exception) {
                println("The flow has thrown an exception: $e")
            }
        }
    }

    fun getPhoto(id:Int){
        viewModelScope.launch {
            repository.getPhotoByIdDb(id).collect{ response->
                statePhoto = response
            }
        }
    }

    fun addPhoto(photoEntity: PhotoEntity){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addPhotoDb(photoEntity)
        }
    }

    fun deletePhoto(photoEntity: PhotoEntity){
        viewModelScope.launch(Dispatchers.IO){
            repository.deletePhoto(photoEntity)
        }
    }
}