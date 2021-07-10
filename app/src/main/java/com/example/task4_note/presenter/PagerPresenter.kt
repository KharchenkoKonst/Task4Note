package com.example.task4_note.presenter

import com.example.task4_note.database.AppDatabase
import com.example.task4_note.database.Note
import com.example.task4_note.view.interfaces.IPagerView

class PagerPresenter(
    private val view: IPagerView,
    private val model: AppDatabase
) {
    suspend fun setAllData() {
        view.setAdapterData(model.noteDao().getAll())
    }
}