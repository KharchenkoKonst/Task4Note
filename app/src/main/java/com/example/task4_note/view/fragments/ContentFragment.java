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
import com.example.task4_note.presenter.ContentFragmentPresenter;
import com.example.task4_note.view.interfaces.IContentFragment;

import org.jetbrains.annotations.NotNull;

public class ContentFragment extends Fragment implements IContentFragment {

    private View view;
    private ContentFragmentPresenter presenter;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_content, container, false);
        init();
        return view;
    }

    private void init() {
        presenter = new ContentFragmentPresenter(this);
        view.findViewById(R.id.saveButton).setOnClickListener(v1 -> {
            presenter.saveNewNote();
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
    public void returnNote(Bundle data) {
        getParentFragmentManager().setFragmentResult(HeadersFragment.GET_NOTE, data);
        getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
    }
}
