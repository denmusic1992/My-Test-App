package com.denischornyyapp.betrendy.framework.di.module.retrofit

import dagger.Module
import dagger.Provides

/**
Created by Denis Chornyy on 13,Май,2020
All rights received.
 */
@Module
class HeadersModule {
    @Provides
    fun provideHeaders() = mutableListOf(Pair("Accept", "application/json"))
}