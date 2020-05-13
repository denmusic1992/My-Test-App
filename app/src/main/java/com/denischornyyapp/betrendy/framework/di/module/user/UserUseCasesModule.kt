package com.denischornyyapp.betrendy.framework.di.module.user

import com.denischornyyapp.betrendy.framework.usecases.UserUseCases
import com.denischornyyapp.domain_layer.repository.UserRepositoryImpl
import com.denischornyyapp.domain_layer.use_cases.user.*
import dagger.Module
import dagger.Provides

/**
Created by Denis Chornyy on 12,Май,2020
All rights received.
 */
@Module
class UserUseCasesModule {
    @Provides
    fun provideUserUseCases(userRepositoryImpl: UserRepositoryImpl) = UserUseCases(
        AddUser(userRepositoryImpl),
        GetUser(userRepositoryImpl),
        FindUser(userRepositoryImpl),
        UpdateUser(userRepositoryImpl),
        DeleteUser(userRepositoryImpl)
    )
}