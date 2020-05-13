package com.denischornyyapp.betrendy.framework.di.module.post

import com.denischornyyapp.betrendy.framework.usecases.PostUseCases
import com.denischornyyapp.domain_layer.repository.PostRepositoryImpl
import com.denischornyyapp.domain_layer.use_cases.post.*
import dagger.Module
import dagger.Provides

/**
Created by Denis Chornyy on 13,Май,2020
All rights received.
 */
@Module
class PostUseCasesModule {
    @Provides
    fun providePostUseCases(postRepositoryImpl: PostRepositoryImpl) = PostUseCases(
        AddPost(postRepositoryImpl),
        UpdatePost(postRepositoryImpl),
        DeletePost(postRepositoryImpl),
        GetAllPosts(postRepositoryImpl),
        GetPostByID(postRepositoryImpl),
        GetPostByUserID(postRepositoryImpl)
    )
}