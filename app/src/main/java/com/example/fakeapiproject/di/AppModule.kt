package com.example.fakeapiproject.di

import com.example.fakeapiproject.common.Constants
import com.example.fakeapiproject.data.remote.api.FakeProjectApi
import com.example.fakeapiproject.data.repository.FakeProjectRepositoryImpl
import com.example.fakeapiproject.domain.repository.FakeProjectRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

object AppModule {

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
    fun providePhotoRepository(api: FakeProjectApi): FakeProjectRepository {
        return FakeProjectRepositoryImpl(api)
    }
}