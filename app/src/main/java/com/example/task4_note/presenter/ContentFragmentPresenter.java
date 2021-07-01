package com.example.task4_note.presenter;

import android.os.Bundle;

import com.example.task4_note.model.ContentFragmentModel;
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

    public void saveNewNote() {
        String header = view.getHeader();
        String body = view.getBody();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yy", Locale.getDefault());
        String date = dateFormat.format(new Date());
        Note note = new Note(header, body, date);

        Bundle result = new Bundle();
        result.putSerializable(HeadersFragment.GET_NOTE, note);
        view.returnNote(result);
    }
}
