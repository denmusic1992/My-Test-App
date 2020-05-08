package com.denischornyyapp.betrendy.framework.database.repository

import android.content.Context
import com.denischornyyapp.betrendy.framework.database.DatabaseService
import com.denischornyyapp.betrendy.framework.database.entities.UserEntity
import com.denischornyyapp.domain_layer.data.User
import com.denischornyyapp.domain_layer.repository.UserRepository
import java.util.*

/**
Created by Denis Chornyy on 06,Май,2020
All rights received.
 */
class   UserRoomRepositoryImpl(context: Context) : UserRepository {
    private val userDao = DatabaseService.getInstance(context).userDao()

    override suspend fun add(user: User) = userDao.insert(UserEntity.fromUser(user))

    override suspend fun get(uuid: UUID): User? = userDao.getUser(uuid.toString())?.toUser()

    override suspend fun getByCredentials(login: String, passwordHash: Int): User? = userDao.findUser(login, passwordHash)?.toUser()

    override suspend fun update(user: User) = userDao.update(UserEntity.fromUser(user))

    override suspend fun delete(user: User) = userDao.delete(UserEntity.fromUser(user))
}