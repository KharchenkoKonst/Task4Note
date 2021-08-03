package com.example.task4_note.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.task4_note.R
import com.example.task4_note.database.AppDatabase
import com.example.task4_note.database.Note
import com.example.task4_note.model.note.NOTE_DATA
import com.example.task4_note.presenter.ContentFragmentPresenter
import com.example.task4_note.view.interfaces.IContentFragment
import kotlinx.coroutines.launch

class ContentFragment : Fragment(), IContentFragment {
    private lateinit var _view: View
    private lateinit var _presenter: ContentFragmentPresenter
    private lateinit var _model: AppDatabase

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _view = inflater.inflate(R.layout.fragment_content, container, false)
        init()
        return _view
    }

    private fun init() {
        _model = AppDatabase.getDatabase(requireActivity().applicationContext)
        _presenter = ContentFragmentPresenter(this, _model)
        _view.findViewById<ImageButton>(R.id.saveButton)
            .setOnClickListener { lifecycleScope.launch { _presenter.saveNote() } }

    }

    override fun getHeader(): String {
        return (_view.findViewById<View>(R.id.headerText) as EditText).text.toString()
    }

    override fun getBody(): String {
        return (_view.findViewById<View>(R.id.bodyText) as EditText).text.toString()
    }

    override fun toTitleFragment(data: Bundle) {
        parentFragmentManager.setFragmentResult(TitleFragment.NEW_NOTE, data)
    }
}