package com.pavlodar.androidacademymovieapp.movies_details.presentation.view_model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pavlodar.androidacademymovieapp.movies_list.data.models.MovieApiData

class MoviesDetailsViewModel(
    movieData: MovieApiData
): ViewModel() {

    private val movieLiveData = MutableLiveData<MovieApiData>(movieData)

    fun getMovieData(): LiveData<MovieApiData> {
        return movieLiveData
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("TAG", "ViewModel killed")
    }
}