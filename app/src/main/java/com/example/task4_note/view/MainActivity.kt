package com.example.task4_note.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.task4_note.R
import com.example.task4_note.view.fragments.AboutDialogFragment
import com.example.task4_note.view.fragments.HeadersFragment
import com.example.task4_note.view.fragments.TitleFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragment = TitleFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment, fragment)
        transaction.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.mainMenu) {
            val dialog = AboutDialogFragment()
            dialog.show(supportFragmentManager, null)
            return true
        }
        return false
    }
}