package com.example.task4_note.view.interfaces

import com.example.task4_note.database.Note

interface ITitleFragment {
    fun addNoteToRecycler(note: Note)
    fun setNotesToRecycler(notes: List<Note>)
}