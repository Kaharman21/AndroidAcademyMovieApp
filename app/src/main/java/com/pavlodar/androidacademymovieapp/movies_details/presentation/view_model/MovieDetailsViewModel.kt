package com.pavlodar.androidacademymovieapp.movies_details.presentation.view_model

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.pavlodar.androidacademymovieapp.movies_details.data.MovieDetailsRepository
import com.pavlodar.androidacademymovieapp.movies_details.data.models.MovieDetails
import com.pavlodar.androidacademymovieapp.movies_details.data.models.api.ActorOneApi
import com.pavlodar.androidacademymovieapp.movies_details.data.models.api.ActorsListApi

class MovieDetailsViewModel(
    private val movieId: Long,
    application: Application
): AndroidViewModel(application) {

    private val movieDetailsRepository = MovieDetailsRepository(application)
    private val movieDetailsLiveData = MutableLiveData<MovieDetails>()
    private val actorsListLiveData = MutableLiveData<List<ActorOneApi>>()

    fun loadData(){
        movieDetailsRepository.getMovieDetails(
            result = { movieDetails, actorsListApi ->
                movieDetailsLiveData.postValue(movieDetails)
                actorsListLiveData.postValue(actorsListApi)
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

    fun getActorsList(): LiveData<List<ActorOneApi>>{
        return actorsListLiveData
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("TAG", "ViewModel killed")
    }
}