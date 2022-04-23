package com.example.unsplashapi.di

import com.example.unsplashapi.api.ImageService
import com.example.unsplashapi.utils.Constants
import com.example.unsplashapi.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideBaseUrl()= BASE_URL
    @Provides
    @Singleton
    fun provideRetrofitInstance(BASE_URL:String): ImageService =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ImageService::class.java)

}