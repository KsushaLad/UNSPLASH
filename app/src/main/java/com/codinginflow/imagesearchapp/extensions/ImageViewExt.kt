package com.codinginflow.imagesearchapp

import android.graphics.drawable.Drawable
import android.os.Build
import android.view.View
import android.widget.ImageView

import androidx.annotation.RequiresApi
import androidx.core.view.isVisible

import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource

import com.bumptech.glide.load.engine.GlideException

import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.codinginflow.imagesearchapp.data.UnsplashPhoto

import kotlinx.android.synthetic.main.fragment_details.view.*


import kotlinx.android.synthetic.main.unsplash_photo_load_state_footer.view.*


import kotlinx.android.synthetic.main.fragment_details.view.progress_bar as progress_bar1

// TODO ачем ты создала 2 отдельных файла с разными названиями? Надо сделать все в одном файле с одним именем.
//  Так же я бы не передавал сюда модель целиком, а закиывал только параметры которые тебе нужны. Тогда ты сможешь
//  создать функции с одним именем, то есть просто переопределить фкнцию с другими параметрами
//Extension DetailsFragment
fun ImageView.loading(photo: UnsplashPhoto) {
    Glide.with(this)
        .load(photo.urls.full)
        .error(R.drawable.ic_error)
        .listener(object : RequestListener<Drawable> {
            @RequiresApi(Build.VERSION_CODES.O)
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>?,
                isFirstResource: Boolean
            ): Boolean {
                if (progress_bar != null) {
                    progress_bar.visibility = View.GONE
                }
                return false
            }

            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: Target<Drawable>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                if (progress_bar != null) {
                    text_view_creator.isVisible = true
                    text_view_description.isVisible = photo.description != null
                    progress_bar.visibility = View.VISIBLE
                }
                return false
            }
        })
        .into(imgImagePreview)
}

