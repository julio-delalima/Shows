package com.coco.shows.framework.ui.list.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.coco.shows.databinding.ItemShowBinding
import com.coco.shows.domain.model.Show
import com.coco.shows.util.loadImage

class ShowHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val binding: ItemShowBinding = ItemShowBinding.bind(itemView)

    fun bind(show: Show?) {
        binding.apply {
            title.text = show?.name
            network.text = show?.network
            show?.image?.let { image.loadImage(it) }
        }
    }

    fun setClickListener(listener: View.OnClickListener) {
        binding.clickable.setOnClickListener(listener)
    }
}