package com.example.mysocialmedia.ui.user

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mysocialmedia.data.model.User
import com.example.mysocialmedia.data.model.idToName
import com.example.mysocialmedia.databinding.ItemUserBinding

class UserAdapter(
    private val users: List<User>,
    private val onClick: (Int) -> Unit
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentUser = users[position]
        holder.binding.apply {
            tvUserName.text = currentUser.userId.idToName()
            cvUser.setOnClickListener {
                onClick.invoke(currentUser.userId)
            }
        }
    }

    override fun getItemCount(): Int {
        return users.size
    }
}