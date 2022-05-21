package com.example.mysocialmedia.data.service

import com.example.mysocialmedia.data.model.Post
import retrofit2.http.GET

interface PlaceHolderService {

    @GET("posts")
    suspend fun fetchPosts(): List<Post>
}