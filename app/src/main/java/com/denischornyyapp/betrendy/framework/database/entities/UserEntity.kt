package com.denischornyyapp.betrendy.framework.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.denischornyyapp.domain_layer.data.User
import java.util.*

/**
Created by Denis Chornyy on 29,Апрель,2020
All rights received.
 */

/**
 * Модель пользователя для room
 */
@Entity(tableName = "user", primaryKeys = ["username", "pass_hash"])
data class UserEntity(
    @ColumnInfo(name = "user_id")
    val userID: String,
    @ColumnInfo(name = "first_name")
    val firstName: String,
    @ColumnInfo(name = "last_name")
    val lastName: String,
    @ColumnInfo(name = "middle_name", defaultValue = "")
    val middleName: String,
    @ColumnInfo(name = "username")
    val username: String,
    @ColumnInfo(name = "pass_hash")
    val passwordHash: Int,
    @ColumnInfo(name = "date_of_birth")
    val birthDate: Long,
    @ColumnInfo(name = "photo_url", defaultValue = "")
    val photoUrl: String,
    @ColumnInfo(name = "allow_geo")
    val allowGeopositioning: Boolean,
    @ColumnInfo(name = "allow_notify")
    val allowNotifications: Boolean
) {
    // конвертирование в data user
    fun toUser() = User(
        UUID.fromString(userID),
        firstName,
        lastName,
        middleName,
        username,
        passwordHash,
        birthDate,
        photoUrl,
        allowGeopositioning,
        allowNotifications
    )

    companion object {
        // конвертирование обратно
        fun fromUser(user: User) =
            UserEntity(
                user.userID.toString(),
                user.firstName,
                user.lastName,
                user.middleName,
                user.username,
                user.passwordHash,
                user.birthDate,
                user.photoURL,
                user.allowGeopositioning,
                user.allowNotifications
            )

        fun createTestUser(): UserEntity {
            val user = User.createTestUser()
            return fromUser(user)
        }
    }
}