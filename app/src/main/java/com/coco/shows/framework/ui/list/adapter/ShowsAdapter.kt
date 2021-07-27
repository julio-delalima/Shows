package com.coco.shows.framework.ui.list.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.coco.shows.R
import com.coco.shows.domain.model.Show

class ShowsAdapter: RecyclerView.Adapter<ShowHolder>() {
    var list = ArrayList<Show>()
    private lateinit var listener: (Show, Int) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowHolder {
        val holder = ShowHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_show, parent, false))

        holder.setClickListener {
            val position = holder.adapterPosition
            getItem(position)?.let { item -> listener(item, position) }
        }

        return holder
    }

    override fun onBindViewHolder(holder: ShowHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemCount() = list.size

    private fun getItem(position: Int): Show? {
        return if (position >= 0 && position < this.list.size) this.list[position] else null
    }

    fun submitList(data: List<Show>) {
        list.apply {
            clear()
            addAll(data)
        }
        notifyDataSetChanged()
    }

    fun setListener(f: (Show, Int)->Unit){
        this.listener = f
    }
}