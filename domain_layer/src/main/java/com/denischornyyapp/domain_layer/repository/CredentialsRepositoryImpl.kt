package com.denischornyyapp.domain_layer.repository

import com.denischornyyapp.domain_layer.data.UserCredentials

/**
Created by Denis Chornyy on 07,Май,2020
All rights received.
 */
class CredentialsRepositoryImpl(private val credentialsRepository: CredentialsRepository) {
    fun checkRegistration() = credentialsRepository.checkRegistration()

    fun getCredentials() = credentialsRepository.getCredentials()

    fun writeCredentials(userCredentials: UserCredentials) = credentialsRepository.writeCredentials(userCredentials)

    fun deleteCredentials() = credentialsRepository.deleteCredentials()
}