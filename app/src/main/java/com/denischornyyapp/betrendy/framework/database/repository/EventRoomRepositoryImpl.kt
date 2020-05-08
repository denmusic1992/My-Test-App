package com.denischornyyapp.betrendy.framework.database.repository

import android.content.Context
import com.denischornyyapp.betrendy.framework.database.DatabaseService
import com.denischornyyapp.betrendy.framework.database.entities.EventEntity
import com.denischornyyapp.domain_layer.data.Event
import com.denischornyyapp.domain_layer.repository.EventRepository
import java.util.*

/**
Created by Denis Chornyy on 06,Май,2020
All rights received.
 */
class EventRoomRepositoryImpl(context: Context) : EventRepository {
    private val eventDao = DatabaseService.getInstance(context).eventDao()

    override suspend fun add(event: Event) = eventDao.insert(EventEntity.fromEvent(event))

    override suspend fun addAll(events: List<Event>) = eventDao.insertAll(events.map { EventEntity.fromEvent(it) })

    override suspend fun get(id: Long): Event? = eventDao.getEvent(id)?.toEvent()

    override suspend fun getAll(): List<Event> = eventDao.getAllEvents().map { it.toEvent() }

    override suspend fun getForAuthor(uuid: UUID): List<Event> = eventDao.getEventsForAuthor(uuid.toString()).map { it.toEvent() }

    override suspend fun update(event: Event) = eventDao.update(EventEntity.fromEvent(event))

    override suspend fun remove(event: Event) = eventDao.delete(EventEntity.fromEvent(event))

    override suspend fun removeForAuthor(uuid: UUID) = eventDao.removeEventsForAuthor(uuid.toString())

}