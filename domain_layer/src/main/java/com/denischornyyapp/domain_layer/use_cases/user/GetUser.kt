package com.denischornyyapp.domain_layer.use_cases.user

import com.denischornyyapp.domain_layer.repository.UserRepositoryImpl
import java.util.*

/**
Created by Denis Chornyy on 29,Апрель,2020
All rights received.
 */
class GetUser(private val userRepositoryImpl: UserRepositoryImpl) {
    suspend operator fun invoke(uuid: UUID) = userRepositoryImpl.getUser(uuid)
}