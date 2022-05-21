package com.example.mysocialmedia.ui.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.mysocialmedia.data.model.Post
import com.example.mysocialmedia.data.model.User
import com.example.mysocialmedia.databinding.FragmentUserBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
@AndroidEntryPoint
class UserFragment(): Fragment() {

    private val viewModel: UserViewModel by viewModels()

    private var binding: FragmentUserBinding? = null

    private var userAdapter: UserAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            viewModel.state.collect {

                when(it) {
                    is UserViewState.Success -> {
                        val posts = it.data
                        val users = posts.map{  post ->
                            User( post.userId )
                        }
                        val uniqueUsers = users.distinctBy {
                            it.userId
                        }
                        userAdapter = UserAdapter(uniqueUsers) { userId ->
                           val userSpecificPosts = posts.filter { post -> post.userId == userId }
                           val action = UserFragmentDirections.actionUserFragmentToPostFragment(userSpecificPosts.toTypedArray())
                           findNavController().navigate(action)

                        }
                        binding?.rvUser?.adapter = userAdapter
                    }
                }
            }
        }

    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

}