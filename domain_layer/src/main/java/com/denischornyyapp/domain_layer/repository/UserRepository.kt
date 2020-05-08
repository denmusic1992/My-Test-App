package com.denischornyyapp.domain_layer.repository

import com.denischornyyapp.domain_layer.data.User
import java.util.*

/**
Created by Denis Chornyy on 29,Апрель,2020
All rights received.
 */

/**
 * Интерфейс для взаимодействия между entity и usecases пользователей
 */
interface UserRepository {

    suspend fun add(user: User)

    suspend fun get(uuid: UUID): User?

    suspend fun getByCredentials(login: String, passwordHash: Int) : User?

    suspend fun update(user: User)

    suspend fun delete(user: User)

}