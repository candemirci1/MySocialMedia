package com.example.mysocialmedia.ui.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mysocialmedia.data.model.Post
import com.example.mysocialmedia.data.repository.PostRepository
import com.example.mysocialmedia.utils.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val postRepository: PostRepository
) : ViewModel() {

    val state = MutableStateFlow<UserViewState>(UserViewState.Loading)
    init {
        getPosts()
    }

    private fun getPosts() {
        viewModelScope.launch {
            postRepository.getPosts().let { result:Result<List<Post>> ->
                when(result) {
                    is Result.Loading -> state.value = UserViewState.Loading
                    is Result.Success -> state.value = UserViewState.Success(result.data ?: listOf())
                    is Result.Error -> state.value = UserViewState.Error(result.message.orEmpty())
                }
            }
        }
    }

}

sealed class UserViewState {
    object Loading: UserViewState()
    data class Success(
        val data: List<Post>
    ): UserViewState()
    data class Error(
        val message: String
    ): UserViewState()
}

