package com.example.task4_note.view.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task4_note.R;
import com.example.task4_note.model.note.Note;
import com.example.task4_note.model.note.NotesAdapter;
import com.example.task4_note.presenter.HeadersFragmentPresenter;
import com.example.task4_note.view.interfaces.IHeadersFragment;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;


public class HeadersFragment extends Fragment implements NotesAdapter.OnNoteListener, IHeadersFragment {

    private View view;
    private HeadersFragmentPresenter presenter;
    private NotesAdapter notesAdapter;
    public static String GET_NOTE = "GET_NOTE";

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_headers, container, false);
        init();
        return view;
    }


    //region init
    private void init() {
        view.findViewById(R.id.addNoteButton).setOnClickListener(v1 -> addNote());
        presenter = new HeadersFragmentPresenter(this);
        recyclerInit();
        listenerInit();
    }

    private void recyclerInit() {
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        notesAdapter = new NotesAdapter(this);
        recyclerView.setAdapter(notesAdapter);
    }

    private void listenerInit() {
        getParentFragmentManager().setFragmentResultListener(GET_NOTE, this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull @NotNull String requestKey, @NonNull @NotNull Bundle result) {
                Note note = (Note) result.getSerializable(GET_NOTE);
                presenter.newNote(note);
            }
        });
    }
    //endregion

    private void addNote() {
        ContentFragment content = new ContentFragment();
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragment, content);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onNoteClick(int position) {

    }

    @Override
    public void addNote(Note note) {
        notesAdapter.addItem(note);
    }
}
