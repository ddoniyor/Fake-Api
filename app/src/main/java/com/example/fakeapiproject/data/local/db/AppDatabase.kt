package com.example.fakeapiproject.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.fakeapiproject.data.local.db.AppDatabase.Companion.DB_VERSION
import com.example.fakeapiproject.data.local.model.PhotoEntity

@Database(entities = [PhotoEntity::class], version = DB_VERSION, exportSchema = false)
abstract class AppDatabase:RoomDatabase() {

    companion object {
        const val DB_VERSION = 1
        const val NAME = "fakeapi.db"
    }
    abstract fun photoDao() : PhotoDao
}