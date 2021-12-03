package com.codinginflow.imagesearchapp.ui.gallery.holders

import androidx.recyclerview.widget.RecyclerView
import com.codinginflow.imagesearchapp.data.UnsplashPhoto
import com.codinginflow.imagesearchapp.databinding.ItemUnsplashPhotoBinding
import com.codinginflow.imagesearchapp.loadingView
import com.codinginflow.imagesearchapp.ui.gallery.UnsplashPhotoAdapter

class PhotoViewHolder(
    private val binding: ItemUnsplashPhotoBinding,
    val listener: UnsplashPhotoAdapter.OnItemClickListener
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(photo: UnsplashPhoto) {
        binding.apply {
            imgImagePreview.loadingView(photo)
            textViewUserName.text = photo.user.username
            root.setOnClickListener {
                val position = bindingAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(photo)
                }
            }
        }
    }
}