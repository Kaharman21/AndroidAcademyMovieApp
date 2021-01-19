package com.pavlodar.androidacademymovieapp.movies_list.presentatin.view_model

import android.app.Application
import android.content.Context
import androidx.lifecycle.*
import com.pavlodar.androidacademymovieapp.data.loadMovies
import com.pavlodar.androidacademymovieapp.movies_list.data.models.Movie
import kotlinx.coroutines.launch

class MovieListViewModel(
    application: Application
): AndroidViewModel(application) {

    private val movieListLiveData = MutableLiveData<List<Movie>>()
 //   private var appContext: Context = application
// private val context = getApplication<Application>().applicationContext

    fun getMovieList(): LiveData<List<Movie>>{

        viewModelScope.launch {
            movieListLiveData.postValue(loadMovies(getApplication()))
        }

        return movieListLiveData
    }
}