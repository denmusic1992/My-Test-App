package com.denischornyyapp.domain_layer.use_cases.event

import com.denischornyyapp.domain_layer.repository.EventRepositoryImpl
import java.util.*

/**
Created by Denis Chornyy on 29,Апрель,2020
All rights received.
 */
class RemoveEventsForAuthor(private val eventRepositoryImpl: EventRepositoryImpl) {
    suspend operator fun invoke(uuid: UUID) = eventRepositoryImpl.removeForAuthor(uuid)
}