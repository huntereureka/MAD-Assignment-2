package com.nyp.sit.movieviewerbasic_starter

import android.app.Application


class MovieViewerApplication(): Application(){

    companion object {

        var movieItemArrays: ArrayList<SimpleMovieItem>?=null
        val appInstance = MovieViewerApplication()

    }



}