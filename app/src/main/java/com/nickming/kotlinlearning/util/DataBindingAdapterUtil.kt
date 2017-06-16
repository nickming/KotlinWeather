package com.nickming.kotlinlearning.util

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * class description here
 * @author nickming
 * @version 1.0.0
 * @since 2017-06-13 上午8:33
 * Copyright (c) 2017 nickming All right reserved.
 */
@BindingAdapter("load_image")
fun loadImage(imageView: ImageView, url: String) {
    Glide.with(imageView.context).load(url).crossFade().into(imageView)
}

@BindingAdapter("load_asset")
fun loadAsset(imageView: ImageView, id: Int) {
    Glide.with(imageView.context).load(id).crossFade().into(imageView)
}