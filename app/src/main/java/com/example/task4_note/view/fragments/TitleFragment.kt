package com.example.task4_note.view.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.task4_note.R
import com.example.task4_note.database.AppDatabase
import com.example.task4_note.database.Note
import com.example.task4_note.model.note.NotesRecyclerAdapter
import com.example.task4_note.presenter.TitleFragmentPresenter
import com.example.task4_note.view.PagerActivity
import com.example.task4_note.view.interfaces.ITitleFragment
import kotlinx.coroutines.launch
import java.io.Serializable
import java.security.AllPermission
import java.util.ArrayList

class TitleFragment : Fragment(), ITitleFragment, NotesRecyclerAdapter.OnNoteListener {
    private lateinit var _view: View
    private lateinit var _presenter: TitleFragmentPresenter
    private lateinit var _model: AppDatabase
    private lateinit var _recyclerAdapter: NotesRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _view = inflater.inflate(R.layout.fragment_headers, container, false)
        init()
        return _view
    }

    private fun init() {
        _view.findViewById<ImageButton>(R.id.addNoteButton).setOnClickListener { v ->
            addNote()
        }
        _model = AppDatabase.getDatabase(requireActivity().applicationContext)
        _presenter = TitleFragmentPresenter(this, _model)
        recyclerInit()
        listenerInit()
    }

    private fun recyclerInit() {
        _recyclerAdapter = NotesRecyclerAdapter(this)
        _view.findViewById<RecyclerView>(R.id.recyclerView).apply {
            layoutManager = LinearLayoutManager(_view.context)
            adapter = _recyclerAdapter
        }
        lifecycleScope.launch { _presenter.initiateRecyclerFromDb() }
    }

    private fun listenerInit() {
        parentFragmentManager.setFragmentResultListener(NEW_NOTE, this) { key, bundle ->
            _presenter.saveNewNote(bundle)
        }

    }

    private fun addNote() {
        requireActivity().supportFragmentManager.beginTransaction().apply {
            add(R.id.fragment, ContentFragment())
            addToBackStack(null)
            commit()
        }
    }

    override fun addNoteToRecycler(note: Note) {
        _recyclerAdapter.addItem(note)
    }

    override fun setNotesToRecycler(notes: List<Note>) {
        _recyclerAdapter.setItems(notes)
    }

    override fun onNoteClick(position: Int) {
        var notes: ArrayList<Note>
        lifecycleScope.launch { notes = _presenter.getAllNotes() as ArrayList<Note> }
        val intent = Intent(requireActivity(), PagerActivity::class.java)
        intent.putExtra(NOTE_ID, position)
        intent.putParcelableArrayListExtra(ALL_NOTES, notes)
        startActivity(intent)
    }

    companion object {
        const val NEW_NOTE = "NEW_NOTE"
        const val NOTE_DATA = "NOTE_DATA"
        const val NOTE_ID = "NOTE_ID"
        const val ALL_NOTES = "ALL_NOTES"
    }
}
