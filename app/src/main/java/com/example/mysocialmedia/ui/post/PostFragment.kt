package com.example.mysocialmedia.ui.post

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mysocialmedia.databinding.FragmentPostBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostFragment:Fragment() {

    private var binding: FragmentPostBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPostBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}