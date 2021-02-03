package com.example.diary

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteAdapter (private val notes: List<Note>) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val diaryTitleTextView: TextView = itemView.findViewById(R.id.diaryTitleTextView)
        val diaryDateTextView: TextView = itemView.findViewById(R.id.diaryDateTextView)
        val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_memory, parent, false)
        return NoteViewHolder(view)
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val pNote = notes[position]
        holder.diaryTitleTextView.text = pNote.title
        holder.diaryDateTextView.text = pNote.date.toString()
        holder.descriptionTextView.text = pNote.description.toString()


    }
}