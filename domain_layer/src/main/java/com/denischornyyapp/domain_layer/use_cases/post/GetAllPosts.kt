package com.denischornyyapp.domain_layer.use_cases.post

import com.denischornyyapp.domain_layer.repository.PostRepositoryImpl

/**
Created by Denis Chornyy on 12,Май,2020
All rights received.
 */
class GetAllPosts(private val postRepositoryImpl: PostRepositoryImpl) {
    suspend operator fun invoke() = postRepositoryImpl.getAllPosts()
}