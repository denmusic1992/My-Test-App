package com.denischornyyapp.betrendy.framework.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.denischornyyapp.betrendy.framework.database.entities.EventEntity
import com.denischornyyapp.betrendy.framework.database.repository.EventRoomRepositoryImpl
import com.denischornyyapp.betrendy.framework.database.repository.UserRoomRepositoryImpl
import com.denischornyyapp.betrendy.framework.di.component.DaggerRegisterViewModelComponent
import com.denischornyyapp.betrendy.framework.di.module.ApplicationModule
import com.denischornyyapp.betrendy.framework.usecases.EventUseCases
import com.denischornyyapp.betrendy.framework.usecases.UserUseCases
import com.denischornyyapp.domain_layer.data.Event
import com.denischornyyapp.domain_layer.data.User
import com.denischornyyapp.domain_layer.repository.EventRepositoryImpl
import com.denischornyyapp.domain_layer.repository.UserRepositoryImpl
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

class RegisterViewModel(application: Application) : AndroidViewModel(application) {
    @Inject
    lateinit var userUseCases: UserUseCases
    @Inject
    lateinit var eventUseCases: EventUseCases

    private val job = Job()
    private val coroutineScope = CoroutineScope(Dispatchers.IO + job)
    var isRegistered = MutableLiveData<Boolean>()

    init {
        DaggerRegisterViewModelComponent.builder()
            .applicationModule(ApplicationModule(getApplication()))
            .build()
            .inject(this)
    }

    fun registerNewUser(user: User) {
        coroutineScope.launch {
            userUseCases.addUser(user)
            isRegistered.postValue(true)
        }
    }

    fun registerUserWithTestEvents(user: User) {
        coroutineScope.launch {
            userUseCases.addUser(user)
            val events = mutableListOf<Event>().apply { repeat(10000) { add(Event.createTestEvent(user.userID)) } }
            eventUseCases.addAllEvents(events)
            isRegistered.postValue(true)
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

}