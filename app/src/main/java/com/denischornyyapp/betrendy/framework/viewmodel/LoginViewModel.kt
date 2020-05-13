package com.denischornyyapp.betrendy.framework.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.denischornyyapp.betrendy.framework.database.repository.UserRoomRepositoryImpl
import com.denischornyyapp.betrendy.framework.di.component.DaggerLoginViewModelComponent
import com.denischornyyapp.betrendy.framework.di.module.ApplicationModule
import com.denischornyyapp.betrendy.framework.preferences.PreferencesRepositoryImpl
import com.denischornyyapp.betrendy.framework.usecases.CredentialUseCases
import com.denischornyyapp.betrendy.framework.usecases.UserUseCases
import com.denischornyyapp.domain_layer.data.UserCredentials
import com.denischornyyapp.domain_layer.repository.CredentialsRepositoryImpl
import com.denischornyyapp.domain_layer.repository.UserRepositoryImpl
import com.denischornyyapp.domain_layer.use_cases.credentials.CheckRegistration
import com.denischornyyapp.domain_layer.use_cases.credentials.DeleteCredentials
import com.denischornyyapp.domain_layer.use_cases.credentials.GetCredentials
import com.denischornyyapp.domain_layer.use_cases.credentials.WriteCredentials
import com.denischornyyapp.domain_layer.use_cases.user.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
Created by Denis Chornyy on 06,Май,2020
All rights received.
 */
class LoginViewModel(application: Application): AndroidViewModel(application) {

    @Inject
    lateinit var userUseCases: UserUseCases
    @Inject
    lateinit var credentialUseCases: CredentialUseCases

    private val job = Job()
    private val coroutineScope = CoroutineScope(Dispatchers.IO + job)
    var loginComplete = MutableLiveData<Boolean>()
    var error = MutableLiveData<Boolean>()

    init {
        DaggerLoginViewModelComponent.builder()
            .applicationModule(ApplicationModule(getApplication()))
            .build()
            .inject(this)
    }

    fun loginUser(login: String, passwordHash: Int) {
        coroutineScope.launch {
            val currentUser = userUseCases.findUser(login, passwordHash)
            if(currentUser != null) {
                credentialUseCases.writeCredentials(UserCredentials.getFromUser(currentUser))
                loginComplete.postValue(true)
            }
            else
                error.postValue(true)
        }
    }

    // Проверка регистрации
    fun checkRegistration() = credentialUseCases.checkRegistration()

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}