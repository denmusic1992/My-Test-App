package com.denischornyyapp.betrendy.framework.di.module.post

import android.app.Application
import com.denischornyyapp.betrendy.framework.network.NetworkRepositoryImpl
import com.denischornyyapp.domain_layer.repository.PostRepositoryImpl
import dagger.Module
import dagger.Provides

/**
Created by Denis Chornyy on 13,Май,2020
All rights received.
 */
@Module
class PostRepositoryImplModule {
    @Provides
    fun providePostRepository() = PostRepositoryImpl(NetworkRepositoryImpl())
}