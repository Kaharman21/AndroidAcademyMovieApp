package com.pavlodar.androidacademymovieapp.movies_details.presentation.view_model

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MovieDetailsViewModelFactory(
    private val movieId: Long,
    private val application: Application
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when (modelClass) {
        MovieDetailsViewModel::class.java ->
            MovieDetailsViewModel(movieId, application)
        else ->
            throw IllegalArgumentException("$modelClass is not registered ViewModel")
    } as T
}