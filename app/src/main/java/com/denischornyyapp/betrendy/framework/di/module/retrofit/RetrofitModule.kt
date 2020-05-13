package com.denischornyyapp.betrendy.framework.di.module.retrofit

import com.denischornyyapp.domain_layer.utils.Config
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
Created by Denis Chornyy on 13,Май,2020
All rights received.
 */
@Module
class RetrofitModule {
    @Provides
    @Singleton
    fun provideRetrofitModule(
        gsonConverterFactory: GsonConverterFactory,
        httpClient: OkHttpClient.Builder
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Config.postUrl)
            .client(httpClient.build())
            .addConverterFactory(gsonConverterFactory)
            .build()
    }
}