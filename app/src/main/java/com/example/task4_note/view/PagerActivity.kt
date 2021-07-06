package com.example.task4_note.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.task4_note.R
import com.example.task4_note.model.note.NotesPagerAdapter

class PagerActivity : AppCompatActivity() {
    private val adapter: NotesPagerAdapter by lazy { getPagerAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pager)
        findViewById<ViewPager2>(R.id.pager).adapter = adapter
    }

    private fun getPagerAdapter() = NotesPagerAdapter(this)
}