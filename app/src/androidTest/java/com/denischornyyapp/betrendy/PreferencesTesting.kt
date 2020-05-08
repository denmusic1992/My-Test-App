package com.denischornyyapp.betrendy

import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import androidx.test.platform.app.InstrumentationRegistry
import com.denischornyyapp.betrendy.framework.database.entities.UserEntity
import com.denischornyyapp.betrendy.framework.preferences.PreferencesRepositoryImpl
import com.denischornyyapp.betrendy.framework.usecases.CredentialUseCases
import com.denischornyyapp.domain_layer.data.UserCredentials
import com.denischornyyapp.domain_layer.repository.CredentialsRepositoryImpl
import com.denischornyyapp.domain_layer.use_cases.credentials.CheckRegistration
import com.denischornyyapp.domain_layer.use_cases.credentials.DeleteCredentials
import com.denischornyyapp.domain_layer.use_cases.credentials.GetCredentials
import com.denischornyyapp.domain_layer.use_cases.credentials.WriteCredentials
import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException
import java.lang.Exception

/**
Created by Denis Chornyy on 07,Май,2020
All rights received.
 */

@RunWith(AndroidJUnit4::class)
@SmallTest
class PreferencesTesting {

    private lateinit var prefs: CredentialsRepositoryImpl
    private lateinit var prefUseCases: CredentialUseCases

    @Before
    fun init() {
        val context = InstrumentationRegistry.getInstrumentation().context
        prefs = CredentialsRepositoryImpl(PreferencesRepositoryImpl(context))
        prefUseCases = CredentialUseCases(
            CheckRegistration(prefs),
            GetCredentials(prefs),
            WriteCredentials(prefs),
            DeleteCredentials(prefs)
        )
    }

    @Test
    @Throws(IOException::class)
    fun checkPreferences() {

        // добавляем тестовые данные
        val user = UserEntity.createTestUser()

        val nullPrefs = prefUseCases.getCredentials()
        assertThat(nullPrefs == null, equalTo(true))
        val currentCredentials = UserCredentials.getFromUser(user.toUser())
        // проверка
        prefUseCases.writeCredentials(currentCredentials)
        val currentPrefs = prefUseCases.getCredentials()
        assertThat(currentPrefs, equalTo(currentCredentials))
        var ifRegistered = prefUseCases.checkRegistration()
        assertThat(ifRegistered, equalTo(true))
        // удаление
        prefUseCases.deleteCredentials()
        ifRegistered = prefUseCases.checkRegistration()
        assertThat(ifRegistered, equalTo(false))
    }

    @After
    @Throws(Exception::class)
    fun deletePreferences() {
        prefUseCases.deleteCredentials()
    }


}