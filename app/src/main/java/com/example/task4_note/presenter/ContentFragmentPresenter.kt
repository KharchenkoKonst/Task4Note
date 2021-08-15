package com.example.task4_note.presenter

import android.os.Bundle
import com.example.task4_note.database.AppDatabase
import com.example.task4_note.model.Note
import com.example.task4_note.view.fragments.TitleFragment
import com.example.task4_note.view.interfaces.IContentFragment
import java.text.SimpleDateFormat
import java.util.*

class ContentFragmentPresenter(private val view: IContentFragment, private val model: AppDatabase) {

    suspend fun saveNote() {
        val header = view.getHeader()
        val body = view.getBody()
        val dateFormat = SimpleDateFormat("dd.MM.yy", Locale.getDefault())
        val date = dateFormat.format(Date())

        val note = Note(date, header, body)

        model.noteDao().insert(note)
        val data = Bundle().apply {
            putSerializable(TitleFragment.NOTE_DATA, note)
        }
        view.toTitleFragment(data)
//        val notes = notes
//        notes.add(note)

//        TempDB.notes = notes

        //        TempDB.Companion.getNotes().add(note);

//        Bundle result = new Bundle();
//        result.putSerializable(HeadersFragment.NOTE_DATA, note);
//        view.returnNewNote(result);
    } //    public void saveExistsNote(String date){
}