package com.denischornyyapp.betrendy.framework.di.component

import com.denischornyyapp.betrendy.framework.di.module.post.NetworkRepositoryImplModule
import com.denischornyyapp.betrendy.framework.di.module.post.PostRepositoryImplModule
import com.denischornyyapp.betrendy.framework.di.module.post.PostUseCasesModule
import com.denischornyyapp.betrendy.framework.viewmodel.NetworkViewModel
import dagger.Component

/**
Created by Denis Chornyy on 13,Май,2020
All rights received.
 */
@Component(modules = [PostRepositoryImplModule::class, PostUseCasesModule::class, NetworkRepositoryImplModule::class])
interface PostViewModelComponent {
    fun inject(networkViewModel: NetworkViewModel)
}