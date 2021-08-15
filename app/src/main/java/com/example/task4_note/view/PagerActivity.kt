package com.example.task4_note.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import com.example.task4_note.R
import com.example.task4_note.database.AppDatabase
import com.example.task4_note.model.Note
import com.example.task4_note.model.NotesPagerAdapter
import com.example.task4_note.presenter.PagerPresenter
import com.example.task4_note.view.fragments.TitleFragment
import com.example.task4_note.view.interfaces.IPagerView
import kotlinx.coroutines.launch

class PagerActivity : AppCompatActivity(), IPagerView {
    private val adapter = NotesPagerAdapter(this)
    private lateinit var model: AppDatabase
    private lateinit var presenter: PagerPresenter
    private lateinit var pager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pager)
        val startPos = intent.extras?.getInt(TitleFragment.NOTE_ID)

        model = AppDatabase.getDatabase(this)
        presenter = PagerPresenter(this, model)
        pager = findViewById(R.id.pager)
        lifecycleScope.launch {
            pager.let {
                it.adapter = adapter
                presenter.setAllData()
                startPos?.run { it.setCurrentItem(startPos, false) }
            }
        }
    }

    fun changeItem(header: String, body: String) {
        val note = adapter.getCurrentItem(pager.currentItem)
        lifecycleScope.launch { presenter.updateData(header, body, note) }
    }

    override fun setAdapterData(notes: List<Note>) {
        adapter.setItems(notes)
    }
}