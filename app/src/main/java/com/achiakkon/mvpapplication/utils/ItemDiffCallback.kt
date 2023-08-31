package com.achiakkon.mvpapplication.utils

import androidx.recyclerview.widget.DiffUtil
import com.achiakkon.mvpapplication.data.Models.Note

class ItemDiffCallback(private val oldItems: List<Note>, private val newItems: List<Note>) :
    DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldItems.size
    }

    override fun getNewListSize(): Int {
        return newItems.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItems[oldItemPosition].title == newItems[newItemPosition].title
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItems[oldItemPosition] === newItems[newItemPosition]
    }
}