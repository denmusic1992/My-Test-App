package com.denischornyyapp.betrendy.framework.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.denischornyyapp.betrendy.framework.database.entities.EventEntity

/**
Created by Denis Chornyy on 29,Апрель,2020
All rights received.
 */

@Dao
interface EventDao : BaseDao<EventEntity> {

    @Insert
    suspend fun insertAll(events: List<EventEntity>)

    @Query("select * from event where id=:id")
    suspend fun getEvent(id: Long): EventEntity?

    @Query("select * from event order by publish_date desc")
    suspend fun getAllEvents(): List<EventEntity>

    @Query("select * from event where author_id=:uuid order by publish_date desc")
    suspend fun getEventsForAuthor(uuid: String): List<EventEntity>

    @Query("delete from event where author_id=:uuid")
    suspend fun removeEventsForAuthor(uuid: String)
}