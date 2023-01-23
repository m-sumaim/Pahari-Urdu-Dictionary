package com.sumaim.pahariDictionary.ui.main.fragment.favorite

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sumaim.pahariDictionary.data.db.entity.Word
import com.sumaim.pahariDictionary.ui.main.fragment.home.HomeAdapter
import com.sumaim.pahariDictionary.ui.main.fragment.home.onItemClick

class FavoriteAdapter()
    : ListAdapter<Word, RecyclerView.ViewHolder>(HomeAdapter.diff){

    lateinit var likeListener: onItemClick
    lateinit var onItemClick: onItemClick

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return FavoriteHolder.create(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is FavoriteHolder)
            holder.bind(getItem(position), onItemClick, likeListener)
    }


}
