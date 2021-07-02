package com.example.task4_note.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.task4_note.R;
import com.example.task4_note.model.note.Note;
import com.example.task4_note.presenter.ContentFragmentPresenter;
import com.example.task4_note.view.interfaces.IContentFragment;

import org.jetbrains.annotations.NotNull;

public class ContentFragment extends Fragment implements IContentFragment {

    private View view;
    private ContentFragmentPresenter presenter;

    private boolean isEdit = false;
    private String date = null;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_content, container, false);
/*
        Как лучше сделать? Я хочу открывать один и тот же фрагмент для создания и просмотра заметки,
        но в первом случае поля будут пустыми (кроме подсказок из xml), а во втором заполнены
        переданными данными о сохранённой заметке, которые, соответственно, будут отображены и доступны для
        изменения.
*/
        Bundle data = getArguments();
        if (data != null) {
            isEdit = true;
            Note note = (Note) data.getSerializable(HeadersFragment.OPEN_NOTE);
            date = note.getDate();
            ((EditText) view.findViewById(R.id.headerText)).setText(note.getHeader());
            ((EditText) view.findViewById(R.id.bodyText)).setText(note.getBody());
        }

        init();
        return view;
    }

    private void init() {
        presenter = new ContentFragmentPresenter(this);
        view.findViewById(R.id.saveButton).setOnClickListener(v1 -> {
            if (isEdit) {
                presenter.saveExistsNote(date);
            } else {
                presenter.saveNewNote();
            }
        });
    }

    @Override
    public String getHeader() {
        return ((EditText) view.findViewById(R.id.headerText)).getText().toString();
    }

    @Override
    public String getBody() {
        return ((EditText) view.findViewById(R.id.bodyText)).getText().toString();
    }

    @Override
    public void returnNewNote(Bundle data) {
        getParentFragmentManager().setFragmentResult(HeadersFragment.NEW_NOTE, data);
        getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
    }

    @Override
    public void returnEditedNote(Bundle data) {
        getParentFragmentManager().setFragmentResult(HeadersFragment.EDITED_NOTE, data);
        getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
    }
}
