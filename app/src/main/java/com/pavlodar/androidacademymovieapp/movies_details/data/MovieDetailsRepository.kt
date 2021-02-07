package com.pavlodar.androidacademymovieapp.movies_details.data

import android.app.Application
import com.pavlodar.androidacademymovieapp.common.data.data_source.MoviesDataBase
import com.pavlodar.androidacademymovieapp.common.data.retrofit.RetrofitClient
import com.pavlodar.androidacademymovieapp.common.utils.mappers.ActorsListMapper
import com.pavlodar.androidacademymovieapp.movies_details.data.models.MovieDetails
import com.pavlodar.androidacademymovieapp.common.utils.mappers.MovieDetailsMapper
import com.pavlodar.androidacademymovieapp.movies_details.data.models.api.Actor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieDetailsRepository(
    private val application: Application
) {

    private val movieDetailsMapper = MovieDetailsMapper()
    private val actorsListMapper = ActorsListMapper()
    private val movieDetailsDb = MoviesDataBase.create(application)

    fun getMovieDetails(
        result: (MovieDetails, List<Actor>) -> Unit,
        fail: (String) -> Unit,
        coroutineScope: CoroutineScope,
        movieId: Long
    ){
        try {
            coroutineScope.launch {
                val movieDetailsFromBd = loadMovieDetailFromDb()
                val actorsListFromApi = loadActorsFromApi(movieId)
                result(movieDetailsFromBd, actorsListFromApi)

                val movieDetailsFromApi: MovieDetails = loadMovieDetailsFromApi(movieId)
                saveMovieDetailsToDb(movieDetailsFromApi)
                result(movieDetailsFromApi, actorsListFromApi)
            }
        } catch (e: Exception){
            fail(e.localizedMessage)
        }

    }

    private suspend fun loadMovieDetailsFromApi(movieId: Long): MovieDetails = withContext(Dispatchers.IO){
        val movieDetailsApi = RetrofitClient.moviesApi.getMovieDetails(movieId)
        movieDetailsMapper.mapFromApiToMovieDetails(movieDetailsApi)
    }

    private suspend fun loadActorsFromApi(movieId: Long): List<Actor> = withContext(Dispatchers.IO){
        val actorsResponse = RetrofitClient.moviesApi.getActors(movieId)
        actorsListMapper.mapToActorsList(actorsResponse.actorsList)
    }

    private suspend fun loadMovieDetailFromDb(): MovieDetails = withContext(Dispatchers.IO){
        val movieDetails = movieDetailsDb.moviesDao.getMoviesDetails()
        movieDetailsMapper.mapFromEntityToMovieDetails(movieDetails)
    }



    private suspend fun saveMovieDetailsToDb(movieDetails: MovieDetails) = withContext(Dispatchers.IO){
        val movieDetailsEntity = movieDetailsMapper.mapFromMovieDetailsToEntity(movieDetails)
        movieDetailsDb.moviesDao.insertToMovieDetails(movieDetailsEntity)
    }
}