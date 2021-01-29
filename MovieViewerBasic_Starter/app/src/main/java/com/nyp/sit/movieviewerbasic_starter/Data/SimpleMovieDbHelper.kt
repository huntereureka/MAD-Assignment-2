package com.nyp.sit.movieviewerbasic_starter.Data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class SimpleMovieDbHelper(c: Context) : SQLiteOpenHelper(c, DATABASE_NAME, null, DATABASE_VER) {

    companion object {
        private val DATABASE_NAME = "simplemovie.db"
        private val DATABASE_TABLE = "simpleMovie"
        private val DATABASE_VER = 1
        private var _db: SQLiteDatabase? = null
        private val context: Context ?= null

        val KEY_ID = "_id"
        val COLUMN_KEY_ID = 0

        val MOVIE_NAME = "movie_name"
        val COLUMN_NAME_ID = 1

        val MOVIE_OVERVIEW = "movie_overview"
        val COLUMN_OVERVIEW_ID = 2

        val MOVIE_RELEASE = "movie_release"
        val COLUMN_RELEASE_ID = 3

        val MOVIE_LANGUAGE = "movie_language"
        val COLUMN_LANGUAGE_ID = 4

        protected val DATABASE_CREATE = ("create table " + DATABASE_TABLE + " "
                + "(" + KEY_ID + " integer primary key autoincrement, "
                + MOVIE_NAME + " Text, "
                + MOVIE_OVERVIEW + " Text, "
                + MOVIE_RELEASE + " Text, "
                + MOVIE_LANGUAGE + " Text );")

        private val MYDBADAPTER_LOG_CAT = "MY_LOG"
    }


    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL(DATABASE_CREATE)
        Log.w(MYDBADAPTER_LOG_CAT, "HELPER : DB $DATABASE_TABLE created!")
    }


    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {


    }
}