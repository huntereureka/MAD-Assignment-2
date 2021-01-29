package com.nyp.sit.mydbapplicationstudent

import android.app.Application
import android.content.Context
import android.database.Cursor
import com.nyp.sit.movieviewerbasic_starter.Data.DatabaseAdapter
import java.util.ArrayList


//TODO 7 :
// - Modify MyContacts class to extend application
// - Declare the two list objects that will hold the id and contact information
// - Create a static instance of MyContacts using the constructor
class MyMovies() : Application(){

    private var movieList: ArrayList<String> = ArrayList<String>()
    private var movieIdList: ArrayList<Int> = ArrayList<Int>()

    companion object {

        val ourInstance = MyMovies()
    }

//TODO 8: Make use of MyDBAdapter's method to perform
//  - insert,
//  - delete,
//  - retrieval of data.

    fun addToDatabase(movieName: String, movieOverview: String, movieRelease: String, movieLanguage: String, c: Context): Long? {
        val db = DatabaseAdapter(c)
        db.open()

        val rowIDofInsertedEntry = db.insertEntry(movieName, movieOverview, movieRelease, movieLanguage)

        db.close()

        return rowIDofInsertedEntry

    }

    fun deleteFrmDatabase(rowID: Int, c: Context): Boolean {
        val db = DatabaseAdapter(c)
        db.open()

        val id = movieIdList[rowID]

        val updateStatus = db.removeEntry(id)

        db.close()

        return updateStatus

    }


    fun retrieveAll(c: Context): List<String> {

        val myCursor: Cursor?
        var myString = ""
        val db = DatabaseAdapter(c)
        db.open()
        movieIdList.clear()
        movieList.clear()
        myCursor = db.retrieveAllEntriesCursor()
        if (myCursor != null && myCursor!!.count > 0) {
            myCursor!!.moveToFirst()
            do {
                movieIdList.add(myCursor.getInt(db.COLUMN_KEY_ID))
                myString = myCursor.getString(db.COLUMN_NAME_ID) + " - " +
                        myCursor.getString(db.COLUMN_OVERVIEW_ID) + "\n" +
                        myCursor.getString(db.COLUMN_RELEASE_ID) + "\n" +
                        myCursor.getString(db.COLUMN_LANGUAGE_ID) + "\n"
                movieList.add(myString)
            } while (myCursor.moveToNext())
        }
        db.close()
        return movieList
    }
}