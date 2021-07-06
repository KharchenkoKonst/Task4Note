package com.example.task4_note.view.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.task4_note.R;
//import com.example.task4_note.model.note.Note;
import com.example.task4_note.model.note.NotesPagerAdapter;
import com.example.task4_note.model.note.NotesRecyclerAdapter;
//import com.example.task4_note.presenter.HeadersFragmentPresenter;
import com.example.task4_note.view.PagerActivity;
import com.example.task4_note.view.interfaces.IHeadersFragment;

import org.jetbrains.annotations.NotNull;

//import java.util.List;


public class HeadersFragment extends Fragment implements NotesRecyclerAdapter.OnNoteListener, IHeadersFragment {

    private View view;
    //    private HeadersFragmentPresenter presenter;
    private NotesRecyclerAdapter notesRecyclerAdapter;
    public static String NOTE_DATA = "NOTE_DATA";
    public static String NEW_NOTE = "NEW_NOTE";
    public static String EDITED_NOTE = "EDITED_NOTE";
    public static String OPEN_NOTE = "OPEN_NOTE";
    public static String REFRESH_HEADERS = "REFRESH_HEADERS";

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
//        presenter = new HeadersFragmentPresenter(this);
        recyclerInit();
        listenerInit();
    }

    private void recyclerInit() {
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        notesRecyclerAdapter = new NotesRecyclerAdapter(this);
        recyclerView.setAdapter(notesRecyclerAdapter);
    }

    private void listenerInit() {
        getParentFragmentManager().setFragmentResultListener(REFRESH_HEADERS, this, (requestKey, result)
                -> notesRecyclerAdapter.refresh());
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
        openPagerView(position);
    }

//    @Override
//    public void addNote() {
//        notesRecyclerAdapter.refresh();
//    }

    public void openPagerView(int idOfSelected) {
        startActivity(new Intent(getActivity(), PagerActivity.class));
/*
        PagerNotesFragment fragment = new PagerNotesFragment();
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragment, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
*/
//        ContentFragment content = new ContentFragment();
//        Bundle data = new Bundle();
//        data.putSerializable(OPEN_NOTE, notes);
//        content.setArguments(data);
//        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
//        transaction.add(R.id.fragment, content);
//        transaction.addToBackStack(null);
//        transaction.commit();
    }

/*
    @Override
    public void saveNoteChanges(@NotNull Note note, int id) {
        notesRecyclerAdapter.editItem(note, id);
    }
*/
}
