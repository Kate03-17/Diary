package com.example.diary

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.fragment.app.Fragment

class FragmentToDo: Fragment(R.layout.fragment_to_do) {
    private lateinit var addButton: Button
    private lateinit var clearButton: Button
    private lateinit var editText: EditText
    private lateinit var listView: ListView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addButton = view.findViewById(R.id.add)
        clearButton = view.findViewById(R.id.clear)
        editText = view.findViewById(R.id.textView)
        listView = view.findViewById(R.id.listView)

        var itemlist = mutableListOf<String>()
        var adapter = ArrayAdapter<String>(view.context, android.R.layout.simple_list_item_multiple_choice, itemlist)

        addButton.setOnClickListener { itemlist.add(editText.text.toString())
            listView.adapter =  adapter

            editText.text.clear() }



        clearButton.setOnClickListener {

            itemlist.clear()
            adapter.notifyDataSetChanged()

        }

        listView.setOnItemClickListener { _, _, _, _ ->

            editText.run { setTextColor(Color.GRAY) }
//            editText.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20F)
//            editText.paintFlags = editText.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG

//            editText.text = Paint.STRIKE_THRU_TEXT_FLAG

        }

    }


    }
