package com.example.task4_note.model.note

import java.io.Serializable

const val NOTE_DATA = "NOTE_DATA"

class oldNote(
//    private val id: Int,
    private var body: String,
    private var header: String,
    private var date: String
) : Serializable {
    fun getBody() = body
    fun getHeader() = header
    fun getDate() = date

    fun setBody(body: String) {
        this.body = body
    }

    fun setHeader(header: String) {
        this.header = header
    }
}