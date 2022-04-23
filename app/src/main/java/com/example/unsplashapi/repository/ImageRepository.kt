package com.example.unsplashapi.repository

import com.example.unsplashapi.api.ImageService
import javax.inject.Inject

class ImageRepository
@Inject
constructor(private val api:ImageService){
    suspend fun getAllImages()= api.getAllImages()
}