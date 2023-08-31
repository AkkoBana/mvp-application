package com.achiakkon.mvpapplication.presentation.notesscreen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.achiakkon.mvpapplication.data.Models.Note
import com.achiakkon.mvpapplication.databinding.ItemNoteLayoutBinding
import com.achiakkon.mvpapplication.utils.ItemDiffCallback

class NoteAdapter(
    private val notes: MutableList<Note>,
    private val setOnClickItem: (Note) -> Unit
) :
    RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    lateinit var binding: ItemNoteLayoutBinding

    class NoteViewHolder(
        private val binding: ItemNoteLayoutBinding,
        private val setOnClickItem: (Note) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Note) = with(binding) {
            itemView.setOnClickListener {
                setOnClickItem.invoke(item)
            }
            tvTitle.text = item.title
            tvContent.text = item.content
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        binding = ItemNoteLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(binding) {
            setOnClickItem.invoke(it)
        }
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(notes[position])
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    fun updateItems(newNotes: List<Note>) {
        val diffCallback = ItemDiffCallback(notes, newNotes)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        notes.clear()
        notes.addAll(newNotes)
        diffResult.dispatchUpdatesTo(this)
    }


}