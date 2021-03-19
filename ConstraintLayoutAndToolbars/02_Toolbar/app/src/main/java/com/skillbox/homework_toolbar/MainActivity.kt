package com.skillbox.homework_toolbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Glide.with(this)
            .load("https://d2s36jztkuk7aw.cloudfront.net/sites/default/files/sticky/twitter_thumbnail.jpg")
            .into(photo)

        toolbar.title = "Beatles Biography"
        initToolbar()
    }

    private fun toastInstruments(instrument: String) {
        Toast.makeText(this, "Playing on $instrument", Toast.LENGTH_SHORT).show()
    }

    private fun toast(text: String) {
        Toast.makeText(this, text , Toast.LENGTH_SHORT).show()
    }

    private fun initToolbar() {
        toolbar.setNavigationOnClickListener {
            Toast.makeText(this, "Navigation Button was clicked!", Toast.LENGTH_SHORT).show()
        }

        toolbar.setOnMenuItemClickListener { menuItem ->
            when(menuItem.itemId) {
                R.id.member1 -> {
                    toastInstruments("guitar & vocal")
                    true
                }
                R.id.member2 -> {
                    toastInstruments("bass & vocal")
                    true
                }
                R.id.member3 -> {
                    toastInstruments("guitar")
                    true
                }
                R.id.member4 -> {
                    toastInstruments("drums")
                    true
                }
                else -> false
            }
        }

        val searchItem = toolbar.menu.findItem(R.id.action_search)
        searchItem.setOnActionExpandListener(object : MenuItem.OnActionExpandListener{
            override fun onMenuItemActionExpand(item: MenuItem?): Boolean {
                toast("Search started!")
                return true
            }

            override fun onMenuItemActionCollapse(item: MenuItem?): Boolean {
                toast("Search ended!")
                return true
            }
        })

        (searchItem.actionView as SearchView).setOnQueryTextListener(
            object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    toast("Search Button Pushed!")
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    toast("Typing...")
                    return true
                }

            })
    }

}