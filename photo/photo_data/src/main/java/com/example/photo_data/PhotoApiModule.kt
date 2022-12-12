package com.example.photo_data

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object PhotoApiModule {
    @Provides
    @Singleton
    fun providePhotoRepository(api: PhotosApi): PhotoRepository {
        return PhotoRepositoryImpl(api)
    }
}