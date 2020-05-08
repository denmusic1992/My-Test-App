package com.denischornyyapp.betrendy.framework.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.denischornyyapp.betrendy.framework.database.dao.EventDao
import com.denischornyyapp.betrendy.framework.database.dao.UserDao
import com.denischornyyapp.betrendy.framework.database.entities.EventEntity
import com.denischornyyapp.betrendy.framework.database.entities.UserEntity

/**
Created by Denis Chornyy on 29,Апрель,2020
All rights received.
 */
@Database(entities = [EventEntity::class, UserEntity::class], version = 3)
abstract class DatabaseService : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun eventDao(): EventDao

    companion object {
        private const val DATABASE_NAME = "betrendy.db"
        private var instance: DatabaseService? = null

        private fun create(context: Context): DatabaseService =
            Room.databaseBuilder(context, DatabaseService::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()

        fun getInstance(context: Context) = (instance ?: create(context)).also { instance = it }
    }
}