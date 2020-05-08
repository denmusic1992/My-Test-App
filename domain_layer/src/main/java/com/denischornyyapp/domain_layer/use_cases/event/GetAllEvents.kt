package com.denischornyyapp.domain_layer.use_cases.event

import com.denischornyyapp.domain_layer.repository.EventRepositoryImpl

/**
Created by Denis Chornyy on 29,Апрель,2020
All rights received.
 */
class GetAllEvents(private val eventRepositoryImpl: EventRepositoryImpl) {
    suspend operator fun invoke() = eventRepositoryImpl.getAllEvents()
}