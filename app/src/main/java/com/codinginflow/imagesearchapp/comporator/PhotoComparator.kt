package com.codinginflow.imagesearchapp.comporator

import androidx.recyclerview.widget.DiffUtil
import com.codinginflow.imagesearchapp.data.UnsplashPhoto

// TODO Это тоже можно положить в папку adapter,  которой он относится. ПОтому что проект будет разростаться,
//  потом будет тяжело следить за тем, для чего какой компоратор
class PhotoComparator : DiffUtil.ItemCallback<UnsplashPhoto>() {

    override fun areItemsTheSame(oldItem: UnsplashPhoto, newItem: UnsplashPhoto) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: UnsplashPhoto, newItem: UnsplashPhoto) =
        oldItem == newItem

}