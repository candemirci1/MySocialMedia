package com.example.mysocialmedia.ui.user

import com.example.mysocialmedia.MainDispatcherRule
import com.example.mysocialmedia.data.model.Post
import com.example.mysocialmedia.data.model.User
import com.example.mysocialmedia.data.repository.PostRepository
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class UserViewModelTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()


    private lateinit var userViewModel: UserViewModel

    @MockK
    private lateinit var repo: PostRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxed = true)
        userViewModel = UserViewModel(repo)
    }

    @Test
    fun getuniqueUsers_workscorrect() {
        val user1 = User(1)
        val user2 = User(2)
        val user3 = User(3)
        val users = listOf<User>(user1,user2,user1,user1,user3,user2,user3,user1)
        val uniqueUsers = userViewModel.getUniqueUsers(users)
        Assert.assertEquals(listOf(user1,user2,user3), uniqueUsers)
    }


    @Test
    fun getUserSpecificPosts_workscorrect() {
        val post1 = Post(1,2,"asd","aaa")
        val post2 = Post(4,1,"ddd","bbb")
        val post3 = Post(5,4,"asddd","ccc")
        val posts = listOf<Post>(post2,post3,post1,)
        val userSpecificPosts = userViewModel.getUserSpecificPosts(posts, 1)
        Assert.assertEquals(listOf(post1), userSpecificPosts)
    }

    @Test
    fun getUsers_workscorrect() {
        val post1 = Post(1,2,"asd","aaa")
        val post2 = Post(4,1,"ddd","bbb")
        val post3 = Post(5,4,"asddd","ccc")
        val posts = listOf<Post>(post1,post2,post3,)
        val user1 = User(1)
        val user2 = User(4)
        val user3 = User(5)
        val users = listOf<User>(user1,user2,user3)
        val actualUsers = userViewModel.getUsers(posts)
        Assert.assertEquals(users,actualUsers)
    }
}