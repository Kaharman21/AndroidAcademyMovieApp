package com.pavlodar.androidacademymovieapp.movies_details.presentation.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pavlodar.androidacademymovieapp.movies_list.data.models.Movie

class MoviesDetailsViewModelFactory(
    private val movie: Movie
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when (modelClass) {
        MoviesDetailsViewModel::class.java ->
            MoviesDetailsViewModel(movie)
        else ->
            throw IllegalArgumentException("$modelClass is not registered ViewModel")
    } as T
}