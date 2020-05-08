package com.denischornyyapp.betrendy.framework.database.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

/**
Created by Denis Chornyy on 29,Апрель,2020
All rights received.
 */

/**
 * азовый интерфейс dao, который нужен во всех dao которые я использую
 */
interface BaseDao<T> {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(vararg obj: T)

    @Update
    suspend fun update(vararg obj: T)

    @Delete
    suspend fun delete(vararg obj: T)
}