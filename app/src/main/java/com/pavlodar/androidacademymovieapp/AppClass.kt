package com.pavlodar.androidacademymovieapp

import android.app.Application
import android.util.Log
import androidx.work.Configuration
import androidx.work.DelegatingWorkerFactory
import com.pavlodar.androidacademymovieapp.movies_list.data.MoviesListRepository
import com.pavlodar.androidacademymovieapp.movies_list.work_manager.MoviesWorkerFactory

class AppClass: Application(), Configuration.Provider {

    private val moviesListRepository by lazy {  MoviesListRepository(this)}

    override fun getWorkManagerConfiguration(): Configuration {
        val workerFactory = DelegatingWorkerFactory()
        workerFactory.addFactory(MoviesWorkerFactory(moviesListRepository))

        return Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .setMinimumLoggingLevel(Log.DEBUG)
            .build()
    }
}