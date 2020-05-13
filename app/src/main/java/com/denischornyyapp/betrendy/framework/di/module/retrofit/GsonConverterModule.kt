package com.denischornyyapp.betrendy.framework.di.module.retrofit

import dagger.Module
import dagger.Provides
import retrofit2.converter.gson.GsonConverterFactory

/**
Created by Denis Chornyy on 13,Май,2020
All rights received.
 */
@Module
class GsonConverterModule {
    @Provides
    fun provideGsonConverter() = GsonConverterFactory.create()
}