package com.denischornyyapp.domain_layer.data

/**
Created by Denis Chornyy on 07,Май,2020
All rights received.
 */

/**
 * Класс для описания хранящихся в префах данных
 */
data class UserCredentials(
    val username: String,
    val passwordHash: Int
) {
    companion object {
        fun getFromUser(user: User) = UserCredentials(user.username, user.passwordHash)
    }
}