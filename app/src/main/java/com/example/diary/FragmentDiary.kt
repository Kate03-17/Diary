package com.example.diary

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_diary.*

class FragmentDiary: Fragment(R.layout.fragment_diary) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        memoriesButton.setOnClickListener {
            val myIntent = Intent(this.context, recyclerActivity::class.java)
            startActivity(myIntent)
        }

        saveButton.setOnClickListener {
            if (dateEditText.text.toString().isEmpty() || personNameEditText.text.toString().isEmpty() || diaryEditText.text.toString().isEmpty()) {
                Toast.makeText(this.context, "Empty", Toast.LENGTH_SHORT).show()
            }else {
                (application as App).notes.add(Note(personNameEditText.text.toString(), dateEditText.text.toString().toInt(), diaryEditText.text.toString()))
                dateEditText.text?.clear()
                personNameEditText.text?.clear()
                diaryEditText.text?.clear()
            }
        }
    }
}