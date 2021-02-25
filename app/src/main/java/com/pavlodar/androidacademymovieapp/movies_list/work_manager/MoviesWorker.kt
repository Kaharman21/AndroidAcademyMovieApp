package com.pavlodar.androidacademymovieapp.movies_list.work_manager

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.pavlodar.androidacademymovieapp.movies_list.data.MoviesListRepository

class MoviesWorker(
    context: Context,
    params: WorkerParameters,
    private val repository: MoviesListRepository
): CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        Log.d("TAG", "Worker updated Info in BD")
        return try {
            repository.updateMoviesListInDb()
            Result.success()
        } catch (e: Exception){
            Result.failure()
        }
    }
}