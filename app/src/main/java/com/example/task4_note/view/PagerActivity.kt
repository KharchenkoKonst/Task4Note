package com.example.task4_note.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    private val adapter: NotesPagerAdapter by lazy { getPagerAdapter() }
    private lateinit var model: AppDatabase
    private lateinit var presenter: PagerPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pager)
        val startPos = intent.extras?.getInt(TitleFragment.NOTE_ID)
        model = AppDatabase.getDatabase(this)
        presenter = PagerPresenter(this, model)
        lifecycleScope.launch { presenter.setAllData() }
        val pager = findViewById<ViewPager2>(R.id.pager)
        pager.adapter = adapter
        if (startPos != null) {
            while (false){ }
            pager.setCurrentItem(startPos, false)
        }
    }

    companion object{
        var test = false
    }

    private fun getPagerAdapter() = NotesPagerAdapter(this)

    override fun setAdapterData(notes: List<Note>) {
        adapter.setItems(notes)
    }
}