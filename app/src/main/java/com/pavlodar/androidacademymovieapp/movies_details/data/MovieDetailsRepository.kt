package com.pavlodar.androidacademymovieapp.movies_details.data

import android.app.Application
import com.pavlodar.androidacademymovieapp.common.data.retrofit.RetrofitClientTwo
import com.pavlodar.androidacademymovieapp.movies_details.data.models.MovieDetails
import com.pavlodar.androidacademymovieapp.common.utils.mappers.MovieDetailsMapper
import com.pavlodar.androidacademymovieapp.movies_details.data.models.api.ActorOneApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MovieDetailsRepository(
    private val application: Application
) {

    private val movieDetailsMapper = MovieDetailsMapper()

    fun getMovieDetails(
        result: (MovieDetails, List<ActorOneApi>) -> Unit,
        fail: (String) -> Unit,
        coroutineScope: CoroutineScope,
        movieId: Long
    ){
        try {
            coroutineScope.launch {
                val movieDetailsApi = RetrofitClientTwo.movieDetailsApi.getMovieDetails(movieId)
                val actorsResponse = RetrofitClientTwo.movieDetailsApi.getActors(movieId)
                val actorsListResponse = actorsResponse.cast
                val movieDetails = movieDetailsMapper.mapToMovieDetails(movieDetailsApi)
                result(movieDetails, actorsListResponse)
            }
        } catch (e: Exception){
            fail(e.localizedMessage)
        }

    }
}