package com.example.unsplashapi.api


import com.example.unsplashapi.models.ImageItem
import com.example.unsplashapi.utils.Constants.CLIENT_ID
import com.example.unsplashapi.utils.Constants.END_POINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface ImageService {
    @Headers("Accept-Version: v1","Authorization: Client-ID $CLIENT_ID")
    @GET(END_POINT)
    suspend fun  getAllImages():Response<List<ImageItem>>

}