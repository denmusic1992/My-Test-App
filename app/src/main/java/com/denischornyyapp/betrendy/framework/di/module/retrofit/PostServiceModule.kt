package com.denischornyyapp.betrendy.framework.di.module.retrofit

import com.denischornyyapp.betrendy.framework.network.PostApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
Created by Denis Chornyy on 13,Май,2020
All rights received.
 */
@Module
class PostServiceModule {
    @Provides
    fun providePostService(retrofit: Retrofit): PostApi = retrofit.create(PostApi::class.java)
}