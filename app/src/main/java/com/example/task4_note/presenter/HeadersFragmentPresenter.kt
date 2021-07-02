package com.example.task4_note.presenter

import com.example.task4_note.view.interfaces.IHeadersFragment
import com.example.task4_note.model.HeadersFragmentModel
import com.example.task4_note.model.note.Note

class HeadersFragmentPresenter(view: IHeadersFragment) {
    private val view = view
    private val model = HeadersFragmentModel()
    private var index: Int? = null

    fun addNote(note: Note) {
        val notes = model.getNotes() as MutableList<Note>
        notes.add(note)
        model.setNotes(notes)
        view.addNote(notes.last())
    }

    fun openNote(index: Int) {
        this.index = index
        val note = model.getNotes()[index]
        view.openNote(note)
    }
    fun editNote(note: Note){
        var notes = model.getNotes() as MutableList<Note>
        notes[index!!] = note
        model.setNotes(notes)
    }
}