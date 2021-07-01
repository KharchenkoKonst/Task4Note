package com.example.task4_note.model

import com.example.task4_note.model.note.Note

class HeadersFragmentModel {
    private var notes = ArrayList<Note>()

    fun setNotes(notes: Collection<Note>) {
        this.notes = notes as ArrayList<Note>
    }

    fun getNote(): Collection<Note> {
        return notes
    }
}