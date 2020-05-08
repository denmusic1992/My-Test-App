package com.denischornyyapp.domain_layer.use_cases.user

import com.denischornyyapp.domain_layer.repository.UserRepositoryImpl

/**
Created by Denis Chornyy on 06,Май,2020
All rights received.
 */
class FindUser(private val userRepositoryImpl: UserRepositoryImpl) {
    suspend operator fun invoke(login: String, passwordHash: Int) = userRepositoryImpl.getUserByCredentials(login, passwordHash)
}