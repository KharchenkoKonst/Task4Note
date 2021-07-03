package com.example.task4_note.view.interfaces

import com.example.task4_note.model.note.Note

interface IHeadersFragment {
    fun addNote(note: Note)
    fun openNote(note: Note)
    fun editNote(note: Note, id: Int)
}