package com.denischornyyapp.domain_layer.repository

import com.denischornyyapp.domain_layer.data.Post

/**
Created by Denis Chornyy on 12,Май,2020
All rights received.
 */
class PostRepositoryImpl(private val postRepository: PostRepository) {
    suspend fun addPost(post: Post) = postRepository.addPost(post)
    suspend fun updatePost(post: Post) = postRepository.updatePost(post)
    suspend fun deletePost(post: Post) = postRepository.deletePost(post)
    suspend fun getAllPosts() = postRepository.getAllPosts()
    suspend fun getPostByID(postID: Long) = postRepository.getPostByID(postID)
    suspend fun getPostsByUserID(userID: Long) = postRepository.getPostsByUserID(userID)
}