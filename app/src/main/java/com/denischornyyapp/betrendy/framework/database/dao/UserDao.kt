package com.denischornyyapp.betrendy.framework.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.denischornyyapp.betrendy.framework.database.entities.UserEntity

/**
Created by Denis Chornyy on 29,Апрель,2020
All rights received.
 */

@Dao
interface UserDao : BaseDao<UserEntity> {
    @Query("select * from user where user_id=:uuid")
    suspend fun getUser(uuid: String): UserEntity?

    @Query("select * from user where username=:login and pass_hash=:passwordHash")
    suspend fun findUser(login: String, passwordHash: Int): UserEntity?
}