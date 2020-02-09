package com.obvious.notesapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.obvious.notesapp.R
import com.obvious.notesapp.domain.Note
import java.util.*
import com.obvious.notesapp.presentation.util.Constants
import java.text.SimpleDateFormat


class NoteAdapter(val itemSelectListener: ItemSelectListener, private val noteList:MutableList<Note> = mutableListOf()) : RecyclerView.Adapter<NoteAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return noteList.size
    }


    fun update(notes: List<Note>) {
        noteList.clear()
        noteList.addAll(notes)
        notifyDataSetChanged()
    }

    fun getAdapterDatePattern(date : Date) : String {
        val simpleDateFormat = SimpleDateFormat(Constants.ADAPTER_DATE_PATTERN)
        return simpleDateFormat.format(date)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(noteList[position])
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(note: Note) {
            val titleView = itemView.findViewById(R.id.titleView) as TextView
            val dateView  = itemView.findViewById(R.id.dateView) as TextView
            titleView.text = note.title
            dateView.text = getAdapterDatePattern(note.date)

            itemView.setOnClickListener {
                itemSelectListener.onItemClick(adapterPosition)
            }
        }
    }

    //interface for recyclerview click
    interface ItemSelectListener {
        fun onItemClick(position: Int)
    }

    //function for geting the note at specific position
    fun getNoteAt(position: Int): Note {
        return noteList.get(position)
    }
}