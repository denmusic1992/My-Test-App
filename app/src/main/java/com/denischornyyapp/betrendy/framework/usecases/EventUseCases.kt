package com.denischornyyapp.betrendy.framework.usecases

import com.denischornyyapp.domain_layer.use_cases.event.*

/**
Created by Denis Chornyy on 29,Апрель,2020
All rights received.
 */
data class EventUseCases(
    val addEvent: AddEvent,
    val addAllEvents: AddAllEvents,
    val getEvent: GetEvent,
    val getAllEvents: GetAllEvents,
    val getEventsForAuthor: GetEventsForAuthor,
    val updateEvent: UpdateEvent,
    val removeEvent: RemoveEvent,
    val removeEventsForAuthor: RemoveEventsForAuthor
)