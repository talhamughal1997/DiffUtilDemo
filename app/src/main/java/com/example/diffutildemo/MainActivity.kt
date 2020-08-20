package com.example.diffutildemo

import android.graphics.LinearGradient
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val adapter by lazy { UserAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setRecyclerView()



    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.user_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.sort_by_name -> {
                adapter.swapItems(Repository.userSortedByName)
                true
            }
            R.id.sort_by_rating -> {
                adapter.swapItems(Repository.userSortedByRating)
                true
            }
            R.id.sort_by_birth -> {
                adapter.swapItems(Repository.userSortedByYearOfBirth)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun setRecyclerView(){
        rv_users.adapter = adapter
        rv_users.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)

        adapter.swapItems(Repository.users)
    }
}