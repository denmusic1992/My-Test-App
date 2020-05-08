package com.denischornyyapp.domain_layer.repository

import com.denischornyyapp.domain_layer.data.Event
import java.util.*

/**
Created by Denis Chornyy on 29,Апрель,2020
All rights received.
 */

/**
 * Интерфейс для связи между entity и usecases событий
 */
interface EventRepository {
    suspend fun add(event: Event)

    suspend fun addAll(events: List<Event>)

    suspend fun get(id: Long): Event?

    suspend fun getAll(): List<Event>

    suspend fun getForAuthor(uuid: UUID): List<Event>

    suspend fun update(event: Event)

    suspend fun remove(event: Event)

    suspend fun removeForAuthor(uuid: UUID)
}