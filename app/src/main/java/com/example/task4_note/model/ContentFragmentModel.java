package com.example.task4_note.model;

import com.example.task4_note.model.note.Note;

import java.util.ArrayList;
import java.util.List;

public class ContentFragmentModel {
    private List<Note> notes;

    public ContentFragmentModel() {
        this.notes = new ArrayList<>();
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public List<Note> getNotes() {
        return this.notes;
    }
}
