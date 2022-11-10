package com.example.fakeapiproject.di

import android.content.Context
import androidx.room.Room
import com.example.fakeapiproject.common.Constants
import com.example.fakeapiproject.data.local.db.AppDatabase
import com.example.fakeapiproject.data.remote.api.FakeProjectApi
import com.example.fakeapiproject.data.repository.FakeProjectRepositoryImpl
import com.example.fakeapiproject.domain.repository.FakeProjectRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import kotlin.math.abs

@Module
@InstallIn(SingletonComponent::class)

object AppModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            AppDatabase.NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideFakeProjectApi(): FakeProjectApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FakeProjectApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(api: FakeProjectApi,db:AppDatabase): FakeProjectRepository {
        return FakeProjectRepositoryImpl(api, db)
    }
}