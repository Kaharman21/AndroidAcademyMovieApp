package com.pavlodar.androidacademymovieapp.movies_list.work_manager

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import com.pavlodar.androidacademymovieapp.movies_list.data.MoviesListRepository

class MoviesWorkerFactory(private val repository: MoviesListRepository) : WorkerFactory() {

    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters
    ): ListenableWorker? {

        return when (workerClassName) {
            MoviesWorker::class.java.name -> {
                MoviesWorker(appContext, workerParameters, repository)
            }
            else -> null
        }
    }
}