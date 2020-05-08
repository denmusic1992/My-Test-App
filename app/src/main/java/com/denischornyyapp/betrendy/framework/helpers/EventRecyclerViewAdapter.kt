package com.denischornyyapp.betrendy.framework.helpers

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.denischornyyapp.betrendy.databinding.ItemEventsListBinding
import com.denischornyyapp.domain_layer.data.Event

/**
Created by Denis Chornyy on 08,Май,2020
All rights received.
 */
class EventRecyclerViewAdapter(
    private val listener: EventClickListener
) : ListAdapter<Event, EventRecyclerViewAdapter.EventRecyclerViewHolder>(EventDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventRecyclerViewHolder {
        val item = ItemEventsListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EventRecyclerViewHolder(item)
    }

    override fun onBindViewHolder(holder: EventRecyclerViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class EventRecyclerViewHolder(private val binding: ItemEventsListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(event: Event) {
            binding.textViewEventTitle.text = event.title
            binding.textViewDescription.text = event.description
            binding.textViewLikesCount.text = event.likesCount.toString()

            binding.root.setOnClickListener { listener.itemClicked(event.id) }
            binding.buttonLikePost.progress = if(event.voted) 1F else 0F
            binding.buttonLikePost.setOnClickListener {
                if(event.voted) {
                    event.voteDown()
                    binding.buttonLikePost.progress = 1F
                    binding.buttonLikePost.speed = -1F
                    binding.buttonLikePost.pauseAnimation()
                    binding.buttonLikePost.playAnimation()
                }
                else {
                    event.voteUp()
                    binding.buttonLikePost.progress = 0F
                    binding.buttonLikePost.speed = 1F
                    binding.buttonLikePost.pauseAnimation()
                    binding.buttonLikePost.playAnimation()
                }
                Log.d("Likes", "Likes count = ${event.likesCount}")
                listener.likeClicked(event)
            }
        }
    }
}