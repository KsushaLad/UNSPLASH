package com.codinginflow.imagesearchapp.ui.gallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.codinginflow.imagesearchapp.comporator.PhotoComparator

import com.codinginflow.imagesearchapp.data.UnsplashPhoto
import com.codinginflow.imagesearchapp.databinding.ItemUnsplashPhotoBinding
import com.codinginflow.imagesearchapp.ui.gallery.holders.PhotoViewHolder

// TODO А почему ты создала отдельную папку для holder, но не создала для adapter.
//  Обычно создается просто папка adapter, и в нее складываются все файлы, которые относятся к нему.
//   ней находятся все адаптеры и холдеры
class UnsplashPhotoAdapter(val listener: OnItemClickListener) :
    PagingDataAdapter<UnsplashPhoto, PhotoViewHolder>(PhotoComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder(
            ItemUnsplashPhotoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), listener
        )
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        getItem(position)?.let { currentItem ->
            holder.bind(currentItem)
        }
    }


    interface OnItemClickListener {
        fun onItemClick(photo: UnsplashPhoto?)
    }
}