package com.nyp.sit.movieviewerbasic_starter

import android.os.Bundle
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.nyp.sit.mydbapplicationstudent.MyMovies
import kotlinx.android.synthetic.main.activity_view_list_of_movies.*

class SimpleViewListOfMoviesActivity : AppCompatActivity() {

    var moviesAdapter: ArrayAdapter<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_list_of_movies)
    }

    //TODO 10 : Add retreiveMovies method
    private fun retrieveMovies() {
        val movieList: List<String>
        val mc = MyMovies.ourInstance
        movieList = mc.retrieveAll(applicationContext)
        moviesAdapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, movieList)
        movielist.adapter = moviesAdapter
    }

    override fun onResume() {
        //TODO 12 : call retrieveContacts();
        retrieveMovies()
        //toggleVisibility()
        super.onResume()
    }

//    override fun onCreateContextMenu(menu: ContextMenu, v: View,
//                                     menuInfo: ContextMenu.ContextMenuInfo) {
//
//        if (v.id == R.id.movielist) {
//            menu.add(1, 0, 0, "Remove")
//        }
//        super.onCreateContextMenu(menu, v, menuInfo)
//    }

    //TODO 11 :  - add onContextItemSelected method
    override fun onContextItemSelected(item: MenuItem): Boolean {
        val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
        val mc = MyMovies.ourInstance
        mc.deleteFrmDatabase(info.position, applicationContext)
        retrieveMovies()
        //toggleVisibility()
        return super.onContextItemSelected(item)
    }
}
