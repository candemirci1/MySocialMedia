package com.example.mysocialmedia.data.repository

import com.example.mysocialmedia.data.model.Post
import com.example.mysocialmedia.data.service.PlaceHolderService
import com.example.mysocialmedia.utils.Result
import retrofit2.HttpException
import java.io.IOException

class PostRepositoryImpl( private val service: PlaceHolderService): PostRepository {

    override suspend fun getPosts(): Result<List<Post>>{
        return try {
            val posts = service.fetchPosts()
            Result.Success(posts)
        } catch (e: HttpException) {
            Result.Error(e.message.orEmpty(),e.code())
        } catch (e:IOException) {
            Result.Error("check your internet connection")
        }
    }


}