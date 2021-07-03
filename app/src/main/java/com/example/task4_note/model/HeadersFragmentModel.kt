package com.example.task4_note.model

import com.example.task4_note.model.note.Note
import java.util.*

class HeadersFragmentModel {
    private var notes = ArrayList<Note>()

    fun setNotes(notes: List<Note>) {
        this.notes = notes as ArrayList<Note>
    }

    fun getNotes(): List<Note> {
        return notes
    }
}