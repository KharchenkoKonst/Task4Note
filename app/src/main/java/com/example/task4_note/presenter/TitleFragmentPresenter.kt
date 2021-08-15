package com.example.task4_note.presenter

import android.os.Bundle
import com.example.task4_note.database.AppDatabase
import com.example.task4_note.model.Note
import com.example.task4_note.view.fragments.TitleFragment.Companion.NOTE_DATA
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
}
