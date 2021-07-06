package com.example.task4_note.presenter;

import android.os.Bundle;

import com.example.task4_note.database.TempDB;
import com.example.task4_note.model.note.Note;
import com.example.task4_note.view.fragments.HeadersFragment;
import com.example.task4_note.view.interfaces.IContentFragment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ContentFragmentPresenter {
    private IContentFragment view;

    public ContentFragmentPresenter(IContentFragment v) {
        view = v;
    }

    public void saveNote() {
        String header = view.getHeader();
        String body = view.getBody();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yy", Locale.getDefault());
        String date = dateFormat.format(new Date());
        Note note = new Note(header, body, date);
        List<Note> notes = TempDB.Companion.getNotes();
        notes.add(note);
        TempDB.Companion.setNotes(notes);
        view.refreshNotes();
//        TempDB.Companion.getNotes().add(note);

//        Bundle result = new Bundle();
//        result.putSerializable(HeadersFragment.NOTE_DATA, note);
//        view.returnNewNote(result);
    }
//    public void saveExistsNote(String date){
//        String header = view.getHeader();
//        String body = view.getBody();
//        Note note = new Note(header, body, date);
//
//        Bundle result = new Bundle();
//        result.putSerializable(HeadersFragment.NOTE_DATA, note);
//        view.returnEditedNote(result);
//    }
}
