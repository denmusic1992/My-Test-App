package com.denischornyyapp.betrendy.framework.usecases

import com.denischornyyapp.domain_layer.use_cases.credentials.CheckRegistration
import com.denischornyyapp.domain_layer.use_cases.credentials.DeleteCredentials
import com.denischornyyapp.domain_layer.use_cases.credentials.GetCredentials
import com.denischornyyapp.domain_layer.use_cases.credentials.WriteCredentials

/**
Created by Denis Chornyy on 07,Май,2020
All rights received.
 */
data class CredentialUseCases(
    val checkRegistration: CheckRegistration,
    val getCredentials: GetCredentials,
    val writeCredentials: WriteCredentials,
    val deleteCredentials: DeleteCredentials
)