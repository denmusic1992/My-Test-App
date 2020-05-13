package com.denischornyyapp.betrendy.framework.di.module

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
Created by Denis Chornyy on 12,Май,2020
All rights received.
 */
@Module
class ApplicationModule(val application: Application) {
    @Provides
    fun provideApp() = application
}