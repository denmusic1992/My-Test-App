package com.denischornyyapp.betrendy.framework.di.component

import com.denischornyyapp.betrendy.framework.di.module.ApplicationModule
import com.denischornyyapp.betrendy.framework.di.module.credentials.CredentialsRepositoryImplModule
import com.denischornyyapp.betrendy.framework.di.module.credentials.CredentialsUseCasesModule
import com.denischornyyapp.betrendy.framework.di.module.user.UserRepositoryImplModule
import com.denischornyyapp.betrendy.framework.di.module.user.UserUseCasesModule
import com.denischornyyapp.betrendy.framework.viewmodel.LoginViewModel
import dagger.Component

/**
Created by Denis Chornyy on 12,Май,2020
All rights received.
 */
@Component(modules = [ApplicationModule::class, UserRepositoryImplModule::class, UserUseCasesModule::class, CredentialsRepositoryImplModule::class, CredentialsUseCasesModule::class ])
interface LoginViewModelComponent {
    fun inject(loginViewModel: LoginViewModel)
}