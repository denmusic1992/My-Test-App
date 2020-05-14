package com.denischornyyapp.betrendy.framework.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.denischornyyapp.betrendy.framework.di.component.DaggerNetworkServiceComponent
import com.denischornyyapp.betrendy.framework.di.component.DaggerPostViewModelComponent
import com.denischornyyapp.betrendy.framework.usecases.PostUseCases
import com.denischornyyapp.domain_layer.data.Post
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
Created by Denis Chornyy on 14,Май,2020
All rights received.
 */
class NetworkViewModel: ViewModel() {

    private val job = Job()
    private val coroutineScope = CoroutineScope(Dispatchers.IO + job)

    var posts = MutableLiveData<List<Post>>()

    @Inject
    lateinit var postUseCases: PostUseCases

    init {
        DaggerPostViewModelComponent.builder()
            .build().inject(this)
    }

    fun getPosts() {
        coroutineScope.launch {
            posts.postValue(postUseCases.getAllPosts())
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}