package com.denischornyyapp.betrendy.framework.di.module.credentials

import com.denischornyyapp.betrendy.framework.usecases.CredentialUseCases
import com.denischornyyapp.domain_layer.repository.CredentialsRepositoryImpl
import com.denischornyyapp.domain_layer.use_cases.credentials.CheckRegistration
import com.denischornyyapp.domain_layer.use_cases.credentials.DeleteCredentials
import com.denischornyyapp.domain_layer.use_cases.credentials.GetCredentials
import com.denischornyyapp.domain_layer.use_cases.credentials.WriteCredentials
import dagger.Module
import dagger.Provides

/**
Created by Denis Chornyy on 12,Май,2020
All rights received.
 */
@Module
class CredentialsUseCasesModule {
    @Provides
    fun provideCredentialsUseCases(credentialsRepositoryImpl: CredentialsRepositoryImpl) =
        CredentialUseCases(
            CheckRegistration(credentialsRepositoryImpl),
            GetCredentials(credentialsRepositoryImpl),
            WriteCredentials(credentialsRepositoryImpl),
            DeleteCredentials(credentialsRepositoryImpl)
        )
}