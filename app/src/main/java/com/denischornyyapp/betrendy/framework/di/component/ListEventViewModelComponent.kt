package com.denischornyyapp.betrendy.framework.di.component

import com.denischornyyapp.betrendy.framework.di.module.*
import com.denischornyyapp.betrendy.framework.di.module.credentials.CredentialsRepositoryImplModule
import com.denischornyyapp.betrendy.framework.di.module.credentials.CredentialsUseCasesModule
import com.denischornyyapp.betrendy.framework.di.module.event.EventRepositoryImplModule
import com.denischornyyapp.betrendy.framework.di.module.event.EventUseCasesModule
import com.denischornyyapp.betrendy.framework.di.module.user.UserRepositoryImplModule
import com.denischornyyapp.betrendy.framework.di.module.user.UserUseCasesModule
import com.denischornyyapp.betrendy.framework.viewmodel.ListEventsViewModel
import dagger.Component

/**
Created by Denis Chornyy on 12,Май,2020
All rights received.
 */
@Component(modules = [ApplicationModule::class, UserRepositoryImplModule::class, UserUseCasesModule::class, EventRepositoryImplModule::class, EventUseCasesModule::class, CredentialsRepositoryImplModule::class, CredentialsUseCasesModule::class])
interface ListEventViewModelComponent {
    fun inject(listEventsViewModel: ListEventsViewModel)
}