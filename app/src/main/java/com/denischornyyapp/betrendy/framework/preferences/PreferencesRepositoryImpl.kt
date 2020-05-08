package com.denischornyyapp.betrendy.framework.preferences

import android.content.Context
import androidx.core.content.edit
import com.denischornyyapp.domain_layer.utils.Config
import com.denischornyyapp.domain_layer.data.UserCredentials
import com.denischornyyapp.domain_layer.repository.CredentialsRepository
import com.google.gson.Gson

/**
Created by Denis Chornyy on 07,Май,2020
All rights received.
 */
class PreferencesRepositoryImpl(context: Context) : CredentialsRepository {
    private val preferences =
        context.getSharedPreferences(Config.appPreferences, Context.MODE_PRIVATE)

    override fun checkRegistration(): Boolean =
        preferences.getBoolean(Config.alreadyRegistered, false)

    override fun getCredentials(): UserCredentials? =
        Gson().fromJson(
            preferences.getString(Config.credentials, null),
            UserCredentials::class.java
        )

    override fun writeCredentials(credentials: UserCredentials) =
        preferences.edit {
            putString(Config.credentials, Gson().toJson(credentials))
            putBoolean(Config.alreadyRegistered, true)
            apply()
        }

    override fun deleteCredentials() = preferences.edit {
        remove(Config.credentials)
        putBoolean(Config.alreadyRegistered, false)
        apply()
    }


}