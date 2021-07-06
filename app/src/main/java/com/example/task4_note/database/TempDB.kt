package com.example.task4_note.database

import com.example.task4_note.model.note.Note

class TempDB {
    companion object {
        var notes = mutableListOf<Note>()

        @JvmName("getNotes1")
        fun getNotes(): List<Note> = notes

        @JvmName("setNotes1")
        fun setNotes(notes: List<Note>) {
            Companion.notes = notes as MutableList<Note>
        }
    }
}