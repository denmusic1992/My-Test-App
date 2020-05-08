package com.denischornyyapp.betrendy.framework.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.denischornyyapp.betrendy.framework.database.repository.UserRoomRepositoryImpl
import com.denischornyyapp.betrendy.framework.usecases.UserUseCases
import com.denischornyyapp.domain_layer.data.User
import com.denischornyyapp.domain_layer.repository.UserRepositoryImpl
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
    private val userRepo: UserRepositoryImpl = UserRepositoryImpl(UserRoomRepositoryImpl(application))

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
    }

    fun registerNewUser(user: User) {
        coroutineScope.launch {
            userUseCases.addUser(user)
            isRegistered.postValue(true)
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

}