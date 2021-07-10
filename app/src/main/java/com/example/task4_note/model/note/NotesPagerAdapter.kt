package com.example.task4_note.model.note

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.task4_note.database.Note
import com.example.task4_note.database.TempDB
import com.example.task4_note.view.PagerActivity
import com.example.task4_note.view.fragments.ContentFragment
import com.example.task4_note.view.fragments.PagerNotesFragment
import com.example.task4_note.view.fragments.TitleFragment


class NotesPagerAdapter(fragment: FragmentActivity) :
    FragmentStateAdapter(fragment) {

    private var notes = emptyList<Note>()

    fun setItems(notes: List<Note>) {
        this.notes = notes
        notifyDataSetChanged()
    }

    fun getCurrentItem(id: Int) = notes[id]

    override fun getItemCount(): Int = notes.size

    override fun createFragment(position: Int): Fragment {
        val page = PagerNotesFragment()
        page.arguments = Bundle().apply {
            putSerializable(TitleFragment.NOTE_DATA, notes[position])
        }
        return page
    }
}