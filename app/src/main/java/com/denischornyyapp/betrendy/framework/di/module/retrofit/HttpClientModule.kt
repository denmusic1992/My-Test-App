package com.denischornyyapp.betrendy.framework.di.module.retrofit

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient

/**
Created by Denis Chornyy on 13,Май,2020
All rights received.
 */
@Module
class HttpClientModule {
    @Provides
    fun provideClientModule(headers: List<Pair<String, String>>): OkHttpClient.Builder {
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor {
            val request = it.request().newBuilder()
            for (pair in headers) {
                request.header(pair.first, pair.second)
            }
            it.proceed(request.build())
        }
        return httpClient
    }
}