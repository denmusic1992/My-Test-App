package com.denischornyyapp.betrendy.framework.helpers

import androidx.recyclerview.widget.DiffUtil
import com.denischornyyapp.domain_layer.data.Post

/**
Created by Denis Chornyy on 14,Май,2020
All rights received.
 */
class PostDiffUtil: DiffUtil.ItemCallback<Post>() {
    override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem.title == newItem.title && oldItem.body == newItem.body
    }
}