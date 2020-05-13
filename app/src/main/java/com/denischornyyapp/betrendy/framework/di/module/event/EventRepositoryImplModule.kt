package com.denischornyyapp.betrendy.framework.di.module.event

import android.app.Application
import com.denischornyyapp.betrendy.framework.database.repository.EventRoomRepositoryImpl
import com.denischornyyapp.domain_layer.repository.EventRepositoryImpl
import dagger.Module
import dagger.Provides

/**
Created by Denis Chornyy on 12,Май,2020
All rights received.
 */
@Module
class EventRepositoryImplModule {
    @Provides
    fun provideEventRepository(application: Application) =
        EventRepositoryImpl(EventRoomRepositoryImpl(application))
}