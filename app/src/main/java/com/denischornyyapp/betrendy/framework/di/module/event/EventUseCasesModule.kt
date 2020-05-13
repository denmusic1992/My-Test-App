package com.denischornyyapp.betrendy.framework.di.module.event

import com.denischornyyapp.betrendy.framework.usecases.EventUseCases
import com.denischornyyapp.domain_layer.repository.EventRepositoryImpl
import com.denischornyyapp.domain_layer.use_cases.event.*
import dagger.Module
import dagger.Provides

/**
Created by Denis Chornyy on 12,Май,2020
All rights received.
 */
@Module
class EventUseCasesModule {
    @Provides
    fun provideEventUseCases(eventRepositoryImpl: EventRepositoryImpl) = EventUseCases(
        AddEvent(eventRepositoryImpl),
        AddAllEvents(eventRepositoryImpl),
        GetEvent(eventRepositoryImpl),
        GetAllEvents(eventRepositoryImpl),
        GetEventsForAuthor(eventRepositoryImpl),
        UpdateEvent(eventRepositoryImpl),
        RemoveEvent(eventRepositoryImpl),
        RemoveEventsForAuthor(eventRepositoryImpl)
    )
}