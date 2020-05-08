package com.denischornyyapp.domain_layer.repository

import com.denischornyyapp.domain_layer.data.Event
import java.util.*

/**
Created by Denis Chornyy on 29,Апрель,2020
All rights received.
 */

/**
 * репоизторий для работы с данными событий
 */
class EventRepositoryImpl(private val eventRepository: EventRepository) {
    suspend fun addEvent(event: Event) = eventRepository.add(event)

    suspend fun addAllEvents(events: List<Event>) = eventRepository.addAll(events)

    suspend fun getEvent(id: Long) = eventRepository.get(id)

    suspend fun getAllEvents() = eventRepository.getAll()

    suspend fun getEventsForAuthor(uuid: UUID) = eventRepository.getForAuthor(uuid)

    suspend fun updateEvent(event: Event) = eventRepository.update(event)

    suspend fun remove(event: Event) = eventRepository.remove(event)

    suspend fun removeForAuthor(uuid: UUID) = eventRepository.removeForAuthor(uuid)
}