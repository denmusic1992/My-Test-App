package com.denischornyyapp.domain_layer.utils

import java.text.SimpleDateFormat
import java.util.*

/**
Created by Denis Chornyy on 29,Апрель,2020
All rights received.
 */

/**
 * Работа с датами
 */
object DateUtils {
    /**
     * Метод конвертации даты в строку
     */
    fun convertDateToString(date: Long): String =
        SimpleDateFormat("MMM dd yyyy", Locale("ru", "RU")).format(Date(date))
}