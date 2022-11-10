package com.example.fakeapiproject.data.local.model

import androidx.compose.runtime.Immutable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = PhotoEntity.TABLE_NAME )
data class PhotoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val thumbnailUrl: String,
    val title: String,
    val url: String
){
    companion object {
        const val TABLE_NAME = "photos"
    }
}
