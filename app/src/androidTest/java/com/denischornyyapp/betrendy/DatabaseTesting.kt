package com.denischornyyapp.betrendy

import android.util.Log
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import androidx.test.platform.app.InstrumentationRegistry
import com.denischornyyapp.betrendy.framework.database.DatabaseService
import com.denischornyyapp.betrendy.framework.database.dao.EventDao
import com.denischornyyapp.betrendy.framework.database.dao.UserDao
import com.denischornyyapp.betrendy.framework.database.entities.EventEntity
import com.denischornyyapp.betrendy.framework.database.entities.UserEntity
import com.denischornyyapp.betrendy.framework.preferences.PreferencesRepositoryImpl
import com.denischornyyapp.betrendy.framework.usecases.CredentialUseCases
import com.denischornyyapp.domain_layer.data.UserCredentials
import com.denischornyyapp.domain_layer.repository.CredentialsRepositoryImpl
import com.denischornyyapp.domain_layer.use_cases.credentials.CheckRegistration
import com.denischornyyapp.domain_layer.use_cases.credentials.DeleteCredentials
import com.denischornyyapp.domain_layer.use_cases.credentials.GetCredentials
import com.denischornyyapp.domain_layer.use_cases.credentials.WriteCredentials
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

/**
Created by Denis Chornyy on 30,Апрель,2020
All rights received.
 */
@RunWith(AndroidJUnit4::class)
@SmallTest
class DatabaseTesting {
    companion object {
        private const val DATABASE_TAG = "database_tag"
    }

    private lateinit var userDao: UserDao
    private lateinit var eventDao: EventDao
    private lateinit var database: DatabaseService
    private lateinit var job: Job

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().context
        database = Room.inMemoryDatabaseBuilder(context, DatabaseService::class.java)
//            .addCallback(object : RoomDatabase.Callback() {
//                override fun onCreate(db: SupportSQLiteDatabase) {
//                    super.onCreate(db)
//                    val user = UserEntity.createTestUser()
//                    val events = mutableListOf<EventEntity>().apply {
//                        repeat(10) {
//                            add(
//                                EventEntity.getTestEvent(user.userID)
//                            )
//                        }
//                    }
//                    runBlocking {
//                        launch {
//                            DatabaseService.getInstance(context).userDao().insert(user)
//                            for (event in events)
//                                DatabaseService.getInstance(context).eventDao().insert(event)
//                        }
//                    }
//                }
//            })
            .build()
        userDao = database.userDao()
        eventDao = database.eventDao()
    }

    @After
    @Throws(IOException::class)
    fun closDb() {
        database.close()
    }

    /**
     * Проверка на добавление пользователя
     */
    @Test
    @Throws(IOException::class)
    fun insertUserAndReadIt() {
        val user = UserEntity.createTestUser()
        val events = mutableListOf<EventEntity>().apply {
            repeat(10) {
                add(
                    EventEntity.getTestEvent(user.userID)
                )
            }
        }
        Log.d(DATABASE_TAG, "test user: $user")
        // записываем в БД
        runBlocking {
            job = launch {
                userDao.insert(user)
                for (event in events)
                    eventDao.insert(event)

                val events = eventDao.getEventsForAuthor(user.userID)
                println(events.toString())
            }
        }
        runBlocking {
            job = launch(Dispatchers.IO) {
                userDao.insert(user)
                try {
                    val inserted = userDao.getUser(user.userID)
                    Log.d(DATABASE_TAG, "inserted user: $inserted")

                    assertThat(inserted, equalTo(user))
                } catch (e: Exception) {
                    Log.d(DATABASE_TAG, "caughtException: ${e.message}")
                }
            }
        }
        Log.d(DATABASE_TAG, "test passed")
    }

    @Test
    @Throws(IOException::class)
    fun insertEventAndReadIt() {
        val user = UserEntity.createTestUser()
        val event = EventEntity.getTestEvent(user.userID)
        runBlocking {
            job = launch(Dispatchers.IO) {
                userDao.insert(user)
                eventDao.insert(event)

                val eventInserted = eventDao.getAllEvents()[0]
                Log.d(DATABASE_TAG, "inserted event: $eventInserted")

                assertThat(eventInserted, equalTo(event))
            }
        }
    }
}