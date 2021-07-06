package com.example.task4_note.model.note

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.task4_note.database.TempDB
import com.example.task4_note.view.fragments.ContentFragment
import com.example.task4_note.view.fragments.HeadersFragment
import com.example.task4_note.view.fragments.PagerNotesFragment

const val NOTE_DATA = "NOTE_DATA"

class NotesPagerAdapter(fragment: FragmentActivity) :
    FragmentStateAdapter(fragment) {

    private val notes = TempDB.getNotes()

    override fun getItemCount(): Int = notes.size

    override fun createFragment(position: Int): Fragment {
        val page = PagerNotesFragment()
        page.arguments = Bundle().apply {
            putSerializable(NOTE_DATA, notes[position])
        }
        return page
    }
}