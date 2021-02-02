package com.example.diary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_recycler.*
import kotlinx.android.synthetic.main.activity_recycler.*

class recyclerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        val noteList = (application as App).notes
        val noteAdapter = NoteAdapter(noteList)
        recycleView.adapter = noteAdapter
        recycleView.layoutManager = LinearLayoutManager(this)
    }
}