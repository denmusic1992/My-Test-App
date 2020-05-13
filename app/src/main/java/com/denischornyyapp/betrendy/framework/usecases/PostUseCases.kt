package com.denischornyyapp.betrendy.framework.usecases

import com.denischornyyapp.domain_layer.use_cases.post.*

/**
Created by Denis Chornyy on 13,Май,2020
All rights received.
 */
data class PostUseCases(
    val addPost: AddPost,
    val updatePost: UpdatePost,
    val deletePost: DeletePost,
    val getAllPosts: GetAllPosts,
    val getPostByID: GetPostByID,
    val getPostByUserID: GetPostByUserID
)