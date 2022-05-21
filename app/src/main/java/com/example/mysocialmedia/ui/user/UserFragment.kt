package com.example.mysocialmedia.ui.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.mysocialmedia.databinding.FragmentUserBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
@AndroidEntryPoint
class UserFragment(): Fragment() {

    private val viewModel: UserViewModel by viewModels()

    private var binding: FragmentUserBinding? = null

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
                     binding?.tvTitle?.text = it.data[0].title
                        binding?.tvBody?.text = it.data[0].body
                        binding?.tvId?.text = it.data[0].id.toString()
                        binding?.tvUserid?.text = it.data[0].userId.toString()
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