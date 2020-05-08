package com.denischornyyapp.domain_layer.use_cases.user

import com.denischornyyapp.domain_layer.data.User
import com.denischornyyapp.domain_layer.repository.UserRepositoryImpl

/**
Created by Denis Chornyy on 29,Апрель,2020
All rights received.
 */

/**
 * Use-case для добавления пользователя
 */
class AddUser(private val userRepositoryImpl: UserRepositoryImpl) {
    suspend operator fun invoke(user: User) = userRepositoryImpl.addUser(user)
}