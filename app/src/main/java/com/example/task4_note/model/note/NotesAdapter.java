package com.example.task4_note.model.note;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task4_note.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {

    private final List<Note> notes = new ArrayList<>();
    private final OnNoteListener onNoteListener;

    public NotesAdapter(OnNoteListener onNoteListener) {
        this.onNoteListener = onNoteListener;
    }

    public void addItem(Note note) {
        this.notes.add(note);
        notifyDataSetChanged();
    }

    public void clearItems() {
        this.notes.clear();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_items, parent, false);
        return new NotesViewHolder(view, onNoteListener);
    }

    @Override
    public void onBindViewHolder(NotesViewHolder holder, int position) {
        holder.header.setText(notes.get(position).getHeader());
        holder.date.setText(notes.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    class NotesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private final TextView header;
        private final TextView date;
        OnNoteListener onNoteListener;

        public NotesViewHolder(View itemView, OnNoteListener onNoteListener) {
            super(itemView);
            header = itemView.findViewById(R.id.headerNote);
            date = itemView.findViewById(R.id.dateNote);

            this.onNoteListener = onNoteListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onNoteListener.onNoteClick(getAdapterPosition());
        }
    }

    public interface OnNoteListener {
        void onNoteClick(int position);
    }
}

