package com.example.task4_note.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.task4_note.R
import com.example.task4_note.view.fragments.AboutDialogFragment
import com.example.task4_note.view.fragments.TitleFragment
import kotlinx.android.synthetic.main.activity_main.*

/*
- Сделать в активити c пролистыванием записей с помощью ViewPager2
- Внутри записи добавить Toolbar с кнопкой по нажатию которой необходимо отобразить диалоговое окно.
- Записи сохранять в Room
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragment = TitleFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment, fragment)
        transaction.commit()

        setSupportActionBar(toolbar as Toolbar?)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    /**
     * Запуск AlertDialog с контентом about
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.aboutMenu) {
            val dialog = AboutDialogFragment()
            dialog.show(supportFragmentManager, null)
            return true
        }
        return false
    }
}