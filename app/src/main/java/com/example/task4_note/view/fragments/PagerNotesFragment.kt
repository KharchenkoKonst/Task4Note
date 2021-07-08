package com.example.task4_note.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.task4_note.R
import com.example.task4_note.database.Note
import com.example.task4_note.model.note.NOTE_DATA

class PagerNotesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_content, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.takeIf { it.containsKey(TitleFragment.NOTE_DATA) }?.apply {
            val header = view.findViewById<EditText>(R.id.headerText)
            val body = view.findViewById<EditText>(R.id.bodyText)
            val data = getSerializable(NOTE_DATA) as Note
            header.setText(data.title)
            body.setText(data.body)
        }
    }

}