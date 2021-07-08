package com.example.task4_note.view.interfaces

import com.example.task4_note.database.Note

interface IPagerView {
    fun setAdapterData(notes: List<Note>)
}