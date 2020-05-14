package com.denischornyyapp.betrendy.framework.di.module.post

import com.denischornyyapp.betrendy.framework.network.NetworkRepositoryImpl
import dagger.Module
import dagger.Provides

/**
Created by Denis Chornyy on 14,Май,2020
All rights received.
 */
@Module
class NetworkRepositoryImplModule {
    @Provides
    fun provideNetworkRepository() = NetworkRepositoryImpl()
}