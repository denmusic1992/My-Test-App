package com.denischornyyapp.domain_layer.repository

import com.denischornyyapp.domain_layer.data.User
import java.util.*

/**
Created by Denis Chornyy on 29,Апрель,2020
All rights received.
 */
/**
 * Репозиторий для работы с данными пользователя
 */
class UserRepositoryImpl(private val userRepository: UserRepository) {
    suspend fun addUser(user: User) = userRepository.add(user)

    suspend fun getUser(uuid: UUID) = userRepository.get(uuid)

    suspend fun getUserByCredentials(login:String, passwordHash: Int) = userRepository.getByCredentials(login, passwordHash)

    suspend fun updateUser(user: User) = userRepository.update(user)

    suspend fun deleteUser(user: User) = userRepository.delete(user)

}