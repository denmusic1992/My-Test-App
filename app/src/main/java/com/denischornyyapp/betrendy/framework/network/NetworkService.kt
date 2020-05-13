package com.denischornyyapp.betrendy.framework.network

import com.denischornyyapp.betrendy.framework.di.component.DaggerNetworkServiceComponent
import com.denischornyyapp.domain_layer.utils.Config
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

/**
Created by Denis Chornyy on 13,Май,2020
All rights received.
 */
object NetworkService {

    lateinit var headers: MutableList<Pair<String, String>>

    lateinit var httpClient: OkHttpClient.Builder

    lateinit var gsonConverterFactory: GsonConverterFactory

    init {
//        DaggerNetworkServiceComponent.builder()
//            .build()
//            .inject(this)
    }

    private val retrofit = Retrofit
        .Builder()
        .baseUrl(Config.postUrl)
        .addConverterFactory(gsonConverterFactory)
        .client(httpClient.build())
        .build()

    fun getService() = retrofit.create(PostApi::class.java)
}