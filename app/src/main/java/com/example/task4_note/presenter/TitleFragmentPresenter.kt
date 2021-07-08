package com.example.task4_note.presenter

import android.os.Bundle
import com.example.task4_note.database.AppDatabase
import com.example.task4_note.database.Note
import com.example.task4_note.model.note.NOTE_DATA
import com.example.task4_note.view.interfaces.ITitleFragment

class TitleFragmentPresenter(private val view: ITitleFragment, private val model: AppDatabase) {
    fun saveNewNote(bundle: Bundle) {
        val note = bundle.getSerializable(NOTE_DATA) as Note
        view.addNoteToRecycler(note)
    }

    suspend fun initiateRecyclerFromDb() {
        val notes = model.noteDao().getAll()
        view.setNotesToRecycler(notes)
    }

    suspend fun getAllNotes() = model.noteDao().getAll()
    //    private var index: Int? = null

//    fun addNote(note: Note) {
//        val notes = model.getNotes() as MutableList<Note>
//        notes.add(note)
//        TempDB.setNotes(notes)
////        view.addNote()
//    }

//    fun changeToPagerMode(index: Int) {
//        view.openPagerView(index)
//    }

//    fun editNote(note: Note) {
//        var notes = model.getNotes() as MutableList<Note>
////        notes[index!!] = note
//        model.setNotes(notes)
////        view.editNote(note, index!!)
//    }
}
