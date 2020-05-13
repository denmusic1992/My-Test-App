package com.denischornyyapp.domain_layer.repository

import com.denischornyyapp.domain_layer.data.Post

/**
Created by Denis Chornyy on 12,Май,2020
All rights received.
 */
interface PostRepository {
    suspend fun getAllPosts(): List<Post>?
    suspend fun getPostByID(postID: Long): Post?
    suspend fun getPostsByUserID(userID: Long): List<Post>?
    suspend fun addPost(post: Post): Post?
    suspend fun updatePost(post: Post): Post?
    suspend fun deletePost(post: Post): Post?
}