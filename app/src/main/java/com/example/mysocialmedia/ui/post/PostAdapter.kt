package com.example.mysocialmedia.ui.post

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mysocialmedia.data.model.Post
import com.example.mysocialmedia.data.model.idToName
import com.example.mysocialmedia.databinding.ItemPostBinding

class PostAdapter(
    private val posts: List<Post>
) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    class PostViewHolder(val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val currentPost = posts[position]
        holder.binding.apply {
            tvUserId.text = currentPost.userId.idToName()
            tvId.text = currentPost.id.toString()
            tvBody.text = currentPost.body
            tvTitle.text = currentPost.title
        }
    }

    override fun getItemCount(): Int {
        return posts.size
    }

}