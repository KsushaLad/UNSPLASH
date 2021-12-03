package com.codinginflow.imagesearchapp

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.codinginflow.imagesearchapp.data.UnsplashPhoto

import kotlinx.android.synthetic.main.fragment_details.view.*


//Extension UnsplashPhotoAdapter
fun ImageView.loadingView(photo: UnsplashPhoto) {
    Glide.with(this@loadingView)
        .load(photo.urls.regular)
        .centerCrop()
        .transition(DrawableTransitionOptions.withCrossFade())
        .error(R.drawable.ic_error)
        .into(imgImagePreview)
}