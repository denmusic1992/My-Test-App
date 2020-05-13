package com.denischornyyapp.betrendy.framework.network

import com.denischornyyapp.betrendy.framework.di.component.DaggerNetworkServiceComponent
import com.denischornyyapp.domain_layer.data.Post
import com.denischornyyapp.domain_layer.repository.PostRepository
import javax.inject.Inject

/**
Created by Denis Chornyy on 13,Май,2020
All rights received.
 */
class NetworkRepositoryImpl: PostRepository {
    @Inject
    lateinit var webService: PostApi

    init {
        DaggerNetworkServiceComponent.builder()
            .build()
            .inject(this)
    }

    override suspend fun getAllPosts(): List<Post>? = webService.getAllPosts()

    override suspend fun getPostByID(postID: Long): Post? = webService.getPostByID(postID)

    override suspend fun getPostsByUserID(userID: Long): List<Post>? = webService.getPostsByUserID(userID)

    override suspend fun addPost(post: Post): Post? = webService.addPost(post)

    override suspend fun updatePost(post: Post): Post? = webService.updatePost(post, post.id)

    override suspend fun deletePost(post: Post) = webService.deletePost(post.id)
}