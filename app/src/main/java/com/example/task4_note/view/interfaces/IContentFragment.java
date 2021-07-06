package com.example.task4_note.view.interfaces;

import android.os.Bundle;

public interface IContentFragment {
    String getHeader();
    String getBody();
    void refreshNotes();
//    void returnEditedNote(Bundle data);
}
