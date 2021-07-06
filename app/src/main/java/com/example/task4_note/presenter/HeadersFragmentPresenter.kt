package com.example.task4_note.presenter

import com.example.task4_note.database.TempDB
import com.example.task4_note.view.interfaces.IHeadersFragment
import com.example.task4_note.model.note.Note

//class HeadersFragmentPresenter(view: IHeadersFragment) {
//    private val view = view
//    private val model = TempDB
//    private var index: Int? = null
//
//    fun addNote(note: Note) {
//        val notes = model.getNotes() as MutableList<Note>
//        notes.add(note)
//        TempDB.setNotes(notes)
//        view.addNote()
//    }
//
//    fun changeToPagerMode(index: Int) {
//        view.openPagerView(index)
//    }

//    fun editNote(note: Note) {
//        var notes = model.getNotes() as MutableList<Note>
//        notes[index!!] = note
//        model.setNotes(notes)
//        view.editNote(note, index!!)
//    }
//}