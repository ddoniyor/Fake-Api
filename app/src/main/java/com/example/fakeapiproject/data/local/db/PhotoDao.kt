package com.example.fakeapiproject.data.local.db

import androidx.room.*
import com.example.fakeapiproject.data.local.model.PhotoEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface PhotoDao {
    @Query("SELECT * FROM ${PhotoEntity.TABLE_NAME} ORDER BY id ASC")
    fun getPhotos(): Flow<List<PhotoEntity>>

    @Query("SELECT * FROM ${PhotoEntity.TABLE_NAME} WHERE id = :id")
    fun getPhotoById(id:Int):Flow<PhotoEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addPhoto(photo:PhotoEntity)

    @Delete
    fun deletePhoto(photo:PhotoEntity)
}