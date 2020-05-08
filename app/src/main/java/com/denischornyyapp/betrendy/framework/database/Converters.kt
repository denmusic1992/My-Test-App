package com.denischornyyapp.betrendy.framework.database

import androidx.room.TypeConverter
import com.google.gson.Gson

/**
Created by Denis Chornyy on 29,Апрель,2020
All rights received.
 */

/**
 * Здесь конвертируются string в list, arraylist, и обратно
 */
class Converters {
    // разрделитель для координат
    private val separator = ';'

    @TypeConverter
    fun listToJson(value: List<String>): String = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String): List<String> = Gson().fromJson(value, Array<String>::class.java).toList()

    @TypeConverter
    fun pairToJson(value: Pair<Double, Double>): String = "${value.first}$separator${value.second}"

    @TypeConverter
    fun jsonToPair(value: String): Pair<Double, Double> {
        val separatorIndex = value.indexOf(separator)
        val latitude = value.substring(0, separatorIndex).toDoubleOrNull()
        val longitude = value.substring(separatorIndex).toDoubleOrNull()
        return Pair(latitude ?: 0.0, longitude ?: 0.0)
    }
}