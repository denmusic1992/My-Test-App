package com.denischornyyapp.betrendy.framework.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.denischornyyapp.betrendy.framework.database.entities.EventEntity
import com.denischornyyapp.betrendy.framework.database.repository.EventRoomRepositoryImpl
import com.denischornyyapp.betrendy.framework.database.repository.UserRoomRepositoryImpl
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

/**
Created by Denis Chornyy on 07,Май,2020
All rights received.
 */

class RegisterViewModel(application: Application) : AndroidViewModel(application) {
    private val userUseCases: UserUseCases
    private val eventUseCases: EventUseCases
    private val userRepo: UserRepositoryImpl = UserRepositoryImpl(UserRoomRepositoryImpl(application))
    private val eventRepo: EventRepositoryImpl = EventRepositoryImpl(EventRoomRepositoryImpl(application))

    private val job = Job()
    private val coroutineScope = CoroutineScope(Dispatchers.IO + job)
    var isRegistered = MutableLiveData<Boolean>()

    init {
        userUseCases = UserUseCases(
            AddUser(userRepo),
            GetUser(userRepo),
            FindUser(userRepo),
            UpdateUser(userRepo),
            DeleteUser(userRepo)
        )

        eventUseCases = EventUseCases(
            AddEvent(eventRepo),
            AddAllEvents(eventRepo),
            GetEvent(eventRepo),
            GetAllEvents(eventRepo),
            GetEventsForAuthor(eventRepo),
            UpdateEvent(eventRepo),
            RemoveEvent(eventRepo),
            RemoveEventsForAuthor(eventRepo)
        )
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