package com.denischornyyapp.betrendy.framework.usecases

import com.denischornyyapp.domain_layer.use_cases.user.*

/**
Created by Denis Chornyy on 29,Апрель,2020
All rights received.
 */

data class UserUseCases(
        val addUser: AddUser,
        val getUser: GetUser,
        val findUser: FindUser,
        val updateUser: UpdateUser,
        val deleteUser: DeleteUser
)