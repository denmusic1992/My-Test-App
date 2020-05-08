package com.denischornyyapp.betrendy.framework.helpers

import com.denischornyyapp.domain_layer.data.Event

/**
Created by Denis Chornyy on 08,Май,2020
All rights received.
 */

/**
 * интерфейс нажатия на элементы в списке
 */
interface EventClickListener {
    fun itemClicked(eventID: Long)
    fun likeClicked(event: Event)
}