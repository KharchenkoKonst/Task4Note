package com.example.task4_note.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import com.example.task4_note.R
import com.example.task4_note.database.AppDatabase
import com.example.task4_note.database.Note
import com.example.task4_note.model.note.NotesPagerAdapter
import com.example.task4_note.presenter.PagerPresenter
import com.example.task4_note.view.fragments.TitleFragment
import com.example.task4_note.view.interfaces.IPagerView
import kotlinx.coroutines.launch

class PagerActivity : AppCompatActivity(), IPagerView {
    private val adapter = NotesPagerAdapter(this)
    private lateinit var model: AppDatabase
    private lateinit var presenter: PagerPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pager)
        val startPos = intent.extras?.getInt(TitleFragment.NOTE_ID)

        model = AppDatabase.getDatabase(this)
        presenter = PagerPresenter(this, model)
        lifecycleScope.launch {
            findViewById<ViewPager2>(R.id.pager).let {
                it.adapter = adapter
                presenter.setAllData()
                startPos?.run { it.setCurrentItem(startPos, false) }
            }
        }
    }

    override fun setAdapterData(notes: List<Note>) {
        adapter.setItems(notes)
    }
}