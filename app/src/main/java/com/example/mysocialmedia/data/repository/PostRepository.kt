package com.example.mysocialmedia.data.repository

import com.example.mysocialmedia.data.model.Post
import com.example.mysocialmedia.utils.Result

interface PostRepository {

    suspend fun getPosts(): Result<List<Post>>
}