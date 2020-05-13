package com.denischornyyapp.betrendy.framework.di.module.credentials

import android.app.Application
import com.denischornyyapp.betrendy.framework.preferences.PreferencesRepositoryImpl
import com.denischornyyapp.domain_layer.repository.CredentialsRepositoryImpl
import dagger.Module
import dagger.Provides

/**
Created by Denis Chornyy on 12,Май,2020
All rights received.
 */
@Module
class CredentialsRepositoryImplModule {
    @Provides
    fun provideCredentialsRepository(application: Application) =
        CredentialsRepositoryImpl(PreferencesRepositoryImpl(application))
}