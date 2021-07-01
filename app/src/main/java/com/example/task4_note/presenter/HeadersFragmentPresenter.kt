package com.example.task4_note.presenter

import com.example.task4_note.view.interfaces.IHeadersFragment
import com.example.task4_note.model.HeadersFragmentModel
import com.example.task4_note.model.note.Note

class HeadersFragmentPresenter(view: IHeadersFragment) {
    private val view = view
    private val model = HeadersFragmentModel()

    fun newNote(note: Note){
        val notes = model.getNote() as MutableList<Note>
        notes.add(note)
        model.setNotes(notes)
        view.addNote(notes.last())
    }
    fun openNote(index : Int){

    }
}