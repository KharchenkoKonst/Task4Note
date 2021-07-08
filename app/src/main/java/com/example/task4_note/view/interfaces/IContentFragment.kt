package com.example.task4_note.view.interfaces

import android.os.Bundle

interface IContentFragment {
    fun getHeader(): String
    fun getBody(): String
    fun toTitleFragment(data: Bundle)
}