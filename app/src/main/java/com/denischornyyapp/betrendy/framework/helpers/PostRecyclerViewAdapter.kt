package com.denischornyyapp.betrendy.framework.helpers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.denischornyyapp.betrendy.R
import com.denischornyyapp.betrendy.databinding.ItemPostBinding
import com.denischornyyapp.domain_layer.data.Post

/**
Created by Denis Chornyy on 14,Май,2020
All rights received.
 */
class PostRecyclerViewAdapter: ListAdapter<Post, PostRecyclerViewAdapter.PostViewHolder>(PostDiffUtil()) {

    inner class PostViewHolder(private val binding: ItemPostBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(post: Post) {
            binding.textViewPostTitle.text = post.title
            binding.textViewDescription.text = post.body
            binding.textViewPublicationDate.text = binding.root.context.getString(R.string.advanced_post_description, post.userId)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val item = ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(item)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}