package com.pavlodar.androidacademymovieapp.movies_list.work_manager

import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequest
import java.util.concurrent.TimeUnit

class MoviesWorkRepository {
    private val constraints = Constraints.Builder()
        .setRequiredNetworkType(NetworkType.UNMETERED)
        .setRequiresCharging(true)
        .build()

    val periodicWorkRequest = PeriodicWorkRequest.Builder(MoviesWorker::class.java,
        30, TimeUnit.SECONDS)
        .setConstraints(constraints)
        .build()

    val simpleRequest = OneTimeWorkRequestBuilder<MoviesWorker>()
        .setInitialDelay(5L, TimeUnit.SECONDS)
        .build()
}