package com.denischornyyapp.domain_layer.use_cases.event

import com.denischornyyapp.domain_layer.data.Event
import com.denischornyyapp.domain_layer.repository.EventRepositoryImpl

/**
Created by Denis Chornyy on 08,Май,2020
All rights received.
 */
class AddAllEvents(private val eventRepositoryImpl: EventRepositoryImpl) {
    suspend operator fun invoke(events: List<Event>) = eventRepositoryImpl.addAllEvents(events)
}