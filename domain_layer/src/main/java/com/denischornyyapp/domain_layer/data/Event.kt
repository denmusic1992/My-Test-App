package com.denischornyyapp.domain_layer.data

import java.util.*

/**
Created by Denis Chornyy on 29,Апрель,2020
All rights received.
 */

/**
 * Класс описания события, созданного пользователем
 */
data class Event(
    val id: Long,
    val title: String,
    val description: String,
    val photosUrl: List<String> = listOf(),
    val publishDate: Long = System.currentTimeMillis(),
    val editDate: Long = publishDate,
    val eventCoordinates: Pair<Double, Double> = Pair(0.0, 0.0),
    var likesCount: Int,
    val authorID: UUID,
    val comments: List<String> = listOf(),
    var voted: Boolean = false
) {

    fun voteUp() {
        likesCount++
        voted = true
    }

    fun voteDown() {
        likesCount--
        voted = false
    }

    companion object {
        fun createTestEvent(authorID: UUID) = Event(
            0,
            "Новое событие",
            "Тут очуметь что происходит",
            listOf(),
            likesCount = (0..9999).random(),
            authorID = authorID
        )
    }
}