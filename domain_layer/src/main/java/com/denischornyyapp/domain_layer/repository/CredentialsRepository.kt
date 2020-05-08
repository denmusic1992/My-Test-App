package com.denischornyyapp.domain_layer.repository

import com.denischornyyapp.domain_layer.data.UserCredentials

/**
Created by Denis Chornyy on 07,Май,2020
All rights received.
 */

/**
 * Интерфейс репозитория для префов
 */
interface CredentialsRepository {
    fun checkRegistration() : Boolean

    fun getCredentials(): UserCredentials?

    fun writeCredentials(credentials: UserCredentials)

    fun deleteCredentials()
}