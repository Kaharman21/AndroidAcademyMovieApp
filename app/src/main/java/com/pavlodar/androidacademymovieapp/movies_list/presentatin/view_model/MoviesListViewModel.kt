package com.pavlodar.androidacademymovieapp.movies_list.presentatin.view_model

import android.app.Application
import androidx.lifecycle.*
import com.pavlodar.androidacademymovieapp.movies_list.data.MoviesListRepository
import com.pavlodar.androidacademymovieapp.movies_list.data.models.MovieData
import com.pavlodar.androidacademymovieapp.movies_list.utils.MoviesListResponseData

class MoviesListViewModel(
    application: Application
): AndroidViewModel(application) {

    private val movieListLiveData = MutableLiveData<MoviesListResponseData<List<MovieData>, String>>()
    private val moviesListRepository = MoviesListRepository(application)

    fun loadData(){

        moviesListRepository.getMoviesList(
            result = {
                movieListLiveData.postValue(MoviesListResponseData.Success(it))
            },
            fail = {
                movieListLiveData.postValue(MoviesListResponseData.Erroe(it))
            },
            viewModelScope
        )
    }

    fun getMoviesList(): LiveData<MoviesListResponseData<List<MovieData>, String>> = movieListLiveData
}