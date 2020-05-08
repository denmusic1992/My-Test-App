package com.denischornyyapp.betrendy.framework.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.denischornyyapp.betrendy.framework.database.Converters
import com.denischornyyapp.domain_layer.data.Event
import java.util.*

/**
Created by Denis Chornyy on 29,Апрель,2020
All rights received.
 */
@Entity(tableName = "event")
@TypeConverters(Converters::class)
data class EventEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val title: String,
    val description: String,
    @ColumnInfo(name = "photos_url")
    val photosUrl: List<String> = listOf(),
    @ColumnInfo(name = "publish_date")
    val publishDate: Long = System.currentTimeMillis(),
    @ColumnInfo(name = "edit_date")
    val editDate: Long = publishDate,
    @ColumnInfo(name = "events_coordinates")
    val eventCoordinates: Pair<Double, Double> = Pair(0.0, 0.0),
    @ColumnInfo(name = "likes_count")
    val likesCount: Int,
    @ColumnInfo(name = "author_id")
    val authorID: String,
    val comments: List<String> = listOf(),
    @ColumnInfo(name = "voted")
    val voted: Boolean = false
) {
    fun toEvent() = Event(
        id,
        title,
        description,
        photosUrl,
        publishDate,
        editDate,
        eventCoordinates,
        likesCount,
        UUID.fromString(authorID),
        comments,
        voted
    )

    companion object {
        fun fromEvent(event: Event) = EventEntity(
            event.id,
            event.title,
            event.description,
            event.photosUrl,
            event.publishDate,
            event.editDate,
            event.eventCoordinates,
            event.likesCount,
            event.authorID.toString(),
            event.comments,
            event.voted
        )

        fun getTestEvent(authorID: String): EventEntity {
            val event = Event.createTestEvent(UUID.fromString(authorID))
            return fromEvent(event)
        }
    }
}