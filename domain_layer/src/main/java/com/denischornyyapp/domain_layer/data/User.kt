package com.denischornyyapp.domain_layer.data

import com.denischornyyapp.domain_layer.utils.Config
import com.denischornyyapp.domain_layer.utils.DateUtils
import java.util.*

/**
Created by Denis Chornyy on 29,Апрель,2020
All rights received.
 */

/**
 * Класс, описывающий пользователя
 * @param userID идентификатор пользователя GUID
 * @param firstName Фамилия
 * @param lastName Имя
 * @param middleName Отчество, по умолчанию пустое
 * @param birthDate дата рождения (в миллисекундах начиная с 1970)
 * @param photoURL фотография профиля
 * @param allowGeopositioning разрешить геопозиционирование
 * @param allowNotifications разрешить уведомления
 */
data class User(
    val userID: UUID = UUID.randomUUID(),
    val firstName: String,
    val lastName: String,
    val middleName: String = "",
    val username: String,
    val passwordHash: Int,
    val birthDate: Long = 0L,
    val photoURL: String = Config.imageTestUrl,
    val allowGeopositioning: Boolean = false,
    val allowNotifications: Boolean = false
) {
    override fun toString(): String {
        return "$firstName $lastName $middleName, дата рождения: ${DateUtils.convertDateToString(
                birthDate
        )}"
    }

    companion object {
        fun createTestUser() =
                User(UUID.randomUUID(), "Пупкин", "Вася", "Тимлидович", "boltorez1488", "12340987".hashCode())
    }
}