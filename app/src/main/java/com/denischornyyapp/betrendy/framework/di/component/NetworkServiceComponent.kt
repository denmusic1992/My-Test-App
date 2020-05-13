package com.denischornyyapp.betrendy.framework.di.component

import com.denischornyyapp.betrendy.framework.di.module.retrofit.*
import com.denischornyyapp.betrendy.framework.network.NetworkRepositoryImpl
import com.denischornyyapp.betrendy.framework.network.NetworkService
import dagger.Component
import javax.inject.Singleton

/**
Created by Denis Chornyy on 13,Май,2020
All rights received.
 */
@Component(modules = [HeadersModule::class, GsonConverterModule::class, HttpClientModule::class, RetrofitModule::class, PostServiceModule::class])
@Singleton
interface NetworkServiceComponent {
    fun inject(networkRepositoryImpl: NetworkRepositoryImpl)
}