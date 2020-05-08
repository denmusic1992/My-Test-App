package com.denischornyyapp.domain_layer.use_cases.credentials

import com.denischornyyapp.domain_layer.repository.CredentialsRepositoryImpl

/**
Created by Denis Chornyy on 07,Май,2020
All rights received.
 */
class CheckRegistration(private val credentialsRepositoryImpl: CredentialsRepositoryImpl) {
    operator fun invoke(): Boolean = credentialsRepositoryImpl.checkRegistration()
}