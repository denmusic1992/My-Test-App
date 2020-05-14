package com.denischornyyapp.betrendy.framework.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.denischornyyapp.betrendy.R

/**
Created by Denis Chornyy on 14,Май,2020
All rights received.
 */
object GlideUtils {
    fun downloadImage(context: Context, url: String, view: ImageView) {
        Glide.with(context) //1
            .load(url)
            .placeholder(R.drawable.ic_blur)
            .error(R.drawable.ic_error)
            .skipMemoryCache(true) //2
            .diskCacheStrategy(DiskCacheStrategy.NONE) //3
            .transform(CircleCrop()) //4
            .into(view)
    }
}