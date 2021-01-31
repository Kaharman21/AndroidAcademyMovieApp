package com.pavlodar.androidacademymovieapp.movies_list.presentatin.view_model

import android.app.Application
import androidx.lifecycle.*
import com.pavlodar.androidacademymovieapp.movies_list.data.MoviesListRepository
import com.pavlodar.androidacademymovieapp.movies_list.data.models.MovieApiData
import com.pavlodar.androidacademymovieapp.movies_list.data.models.MovieData

class MovieListViewModel(
    application: Application
): AndroidViewModel(application) {

    private val movieListLiveData = MutableLiveData<List<MovieData>>()
    private val moviesListRepository = MoviesListRepository(application)

    fun getMovieList(): LiveData<List<MovieData>>{

        moviesListRepository.getMoviesList(
            result = {
                movieListLiveData.postValue(it)
            },
            fail = {

            },
            viewModelScope
        )
        return movieListLiveData
    }

    override fun onCleared() {
        super.onCleared()
    }
}