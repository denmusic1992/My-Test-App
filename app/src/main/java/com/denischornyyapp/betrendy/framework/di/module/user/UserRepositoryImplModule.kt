package com.denischornyyapp.betrendy.framework.di.module.user

import android.app.Application
import com.denischornyyapp.betrendy.framework.database.repository.UserRoomRepositoryImpl
import com.denischornyyapp.domain_layer.repository.UserRepositoryImpl
import dagger.Module
import dagger.Provides

/**
Created by Denis Chornyy on 12,Май,2020
All rights received.
 */
@Module
class UserRepositoryImplModule {
    @Provides
    fun provideUserRepository(application: Application) =
        UserRepositoryImpl(UserRoomRepositoryImpl(application))
}