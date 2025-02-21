package com.ds.basicapp.app.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.ds.basicapp.R

fun ImageView.loadAsyncImage(resourceId: Int) {
    Glide
        .with(this.context)
        .load(resourceId)
        .into(this)
}

fun ImageView.loadAsyncImage(url: String?) {
    Glide
        .with(this.context)
        .load(url)
        .error(R.drawable.img_empty)
        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
        .into(this)
}