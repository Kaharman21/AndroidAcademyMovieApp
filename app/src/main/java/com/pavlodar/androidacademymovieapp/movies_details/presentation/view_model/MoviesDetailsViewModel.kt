package com.pavlodar.androidacademymovieapp.movies_details.presentation.view_model

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pavlodar.androidacademymovieapp.movies_list.data.models.Movie

class MoviesDetailsViewModel(
    movie: Movie
): ViewModel() {

    private val movieLiveData = MutableLiveData<Movie>(movie)

    fun getMovieData(): LiveData<Movie> {
        return movieLiveData
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("TAG", "ViewModel killed")
    }
}