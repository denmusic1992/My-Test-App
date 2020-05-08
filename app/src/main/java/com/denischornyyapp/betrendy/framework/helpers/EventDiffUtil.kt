package com.denischornyyapp.betrendy.framework.helpers

import androidx.recyclerview.widget.DiffUtil
import com.denischornyyapp.domain_layer.data.Event

/**
Created by Denis Chornyy on 08,Май,2020
All rights received.
 */
class EventDiffUtil: DiffUtil.ItemCallback<Event>() {
    override fun areItemsTheSame(oldItem: Event, newItem: Event): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Event, newItem: Event): Boolean {
        return oldItem.authorID == newItem.authorID && oldItem.editDate == newItem.editDate && oldItem.likesCount == newItem.likesCount
    }


}