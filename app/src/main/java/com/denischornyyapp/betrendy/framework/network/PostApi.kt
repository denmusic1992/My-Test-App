package com.denischornyyapp.betrendy.framework.network

import com.denischornyyapp.domain_layer.data.Post
import retrofit2.http.*

/**
Created by Denis Chornyy on 13,Май,2020
All rights received.
 */
interface PostApi {
    @POST("/posts")
    suspend fun addPost(post: Post): Post?

    @PUT("posts/{id}")
    suspend fun updatePost(post: Post, @Path("id") postID: Long): Post?

    @DELETE("/posts/{id}")
    suspend fun deletePost(@Path("id") postID: Long): Post?

    @GET("/posts")
    suspend fun getAllPosts(): List<Post>?

    @GET("/posts/{id}")
    suspend fun getPostByID(@Path("id") postID: Long): Post?

    @GET("/posts?userId={id}")
    suspend fun getPostsByUserID(@Path("id") userID: Long): List<Post>?
}