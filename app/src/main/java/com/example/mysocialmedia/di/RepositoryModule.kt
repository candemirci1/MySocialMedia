package com.example.mysocialmedia.di

import com.example.mysocialmedia.data.repository.PostRepository
import com.example.mysocialmedia.data.repository.PostRepositoryImpl
import com.example.mysocialmedia.data.service.PlaceHolderService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providePostRepository (service: PlaceHolderService): PostRepository {
        return PostRepositoryImpl(service)
    }
}