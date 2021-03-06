package com.denischornyyapp.betrendy.framework.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.denischornyyapp.betrendy.framework.database.repository.EventRoomRepositoryImpl
import com.denischornyyapp.betrendy.framework.database.repository.UserRoomRepositoryImpl
import com.denischornyyapp.betrendy.framework.di.component.DaggerListEventViewModelComponent
import com.denischornyyapp.betrendy.framework.di.module.ApplicationModule
import com.denischornyyapp.betrendy.framework.preferences.PreferencesRepositoryImpl
import com.denischornyyapp.betrendy.framework.usecases.CredentialUseCases
import com.denischornyyapp.betrendy.framework.usecases.EventUseCases
import com.denischornyyapp.betrendy.framework.usecases.UserUseCases
import com.denischornyyapp.domain_layer.data.Event
import com.denischornyyapp.domain_layer.repository.CredentialsRepositoryImpl
import com.denischornyyapp.domain_layer.repository.EventRepositoryImpl
import com.denischornyyapp.domain_layer.repository.UserRepositoryImpl
import com.denischornyyapp.domain_layer.use_cases.credentials.CheckRegistration
import com.denischornyyapp.domain_layer.use_cases.credentials.DeleteCredentials
import com.denischornyyapp.domain_layer.use_cases.credentials.GetCredentials
import com.denischornyyapp.domain_layer.use_cases.credentials.WriteCredentials
import com.denischornyyapp.domain_layer.use_cases.event.*
import com.denischornyyapp.domain_layer.use_cases.user.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
Created by Denis Chornyy on 07,Май,2020
All rights received.
 */
class ListEventsViewModel(application: Application) : AndroidViewModel(application) {

    @Inject
    lateinit var credentialUseCases: CredentialUseCases
    @Inject
    lateinit var userUseCases: UserUseCases
    @Inject
    lateinit var eventUseCases: EventUseCases


    private val job = Job()
    private val coroutineScope = CoroutineScope(Dispatchers.IO + job)
    var signout = MutableLiveData<Boolean>()
    var events = MutableLiveData<List<Event>>()

    init {
        DaggerListEventViewModelComponent.builder()
            .applicationModule(ApplicationModule(getApplication()))
            .build()
            .inject(this)
    }

    /**
     * Получить события этого пользователя
     */
    fun receiveEvents() {
        coroutineScope.launch {
            credentialUseCases.getCredentials()?.also {
                userUseCases.findUser(it.username, it.passwordHash)?.also { user ->
                    events.postValue(eventUseCases.getEventsForAuthor(user.userID))
                }
            }
        }
    }


    /**
     * Поставить лайк
     */
    fun likePost(event: Event) {
        coroutineScope.launch {
            eventUseCases.updateEvent(event)
            events.postValue(eventUseCases.getEventsForAuthor(event.authorID))
        }
    }

    /**
     * Выход пользователя
     */
    fun signOut() {
        credentialUseCases.deleteCredentials()
        signout.value = true
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}