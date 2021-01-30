package com.pavlodar.androidacademymovieapp.movies_details.presentation.view_model

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.pavlodar.androidacademymovieapp.movies_details.data.MovieDetailsRepository
import com.pavlodar.androidacademymovieapp.movies_details.data.models.MovieDetails

class MovieDetailsViewModel(
    private val movieId: Long,
    application: Application
): AndroidViewModel(application) {

    private val movieDetailsRepository = MovieDetailsRepository(application)
    private val movieDetailsLiveData = MutableLiveData<MovieDetails>()

    fun loadData(){
        movieDetailsRepository.getMovieDetails(
            result = {
                movieDetailsLiveData.postValue(it)
            },
            fail = {

            },
            coroutineScope = viewModelScope,
            movieId = movieId
        )
    }

    fun getMovieDetails(): LiveData<MovieDetails>{
        return movieDetailsLiveData
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("TAG", "ViewModel killed")
    }
}