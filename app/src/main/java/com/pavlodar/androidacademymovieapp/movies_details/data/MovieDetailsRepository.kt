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
     //   result: (MovieDetails) -> Unit,
        fail: (String) -> Unit,
        coroutineScope: CoroutineScope,
        movieId: Long
    ) {
        try {
            coroutineScope.launch {
                movieId
                val movieDetailsFromBd = loadMovieDetailFromDb(movieId)
                val actorsListFromDb = loadActorsFromDb(movieId)
                result(movieDetailsFromBd, actorsListFromDb)

                val movieDetailsFromApi = loadMovieDetailsFromApi(movieId)
                val actorsListFromApi = loadActorsFromApi(movieId)
                saveMovieDetailsToDb(movieDetailsFromApi)
                saveActorsToDb(actorsListFromApi)
                result(movieDetailsFromApi, actorsListFromApi)

 //               val movieDetailsWithActors = loadMovieDetailsWithActors(movieId)
 //               result(movieDetailsWithActors)
            }
        } catch (e: Exception) {
            fail(e.localizedMessage)
        }

    }

    private suspend fun loadMovieDetailsFromApi(movieId: Long): MovieDetails =
        withContext(Dispatchers.IO) {
            val movieDetailsApi = RetrofitClient.moviesApi.getMovieDetails(movieId)
            movieDetailsMapper.mapFromApiToMovieDetails(movieDetailsApi)
        }

    private suspend fun loadActorsFromApi(movieId: Long): List<Actor> =
        withContext(Dispatchers.IO) {
            val actorsResponse = RetrofitClient.moviesApi.getActors(movieId)
            actorsListMapper.mapFromApiToActorsList(actorsResponse.actorsList)
        }

    private suspend fun loadMovieDetailFromDb(movieId: Long): MovieDetails =
        withContext(Dispatchers.IO) {
            val movieDetails = movieDetailsDb.moviesDao.getMoviesDetailsById(movieId)
            movieDetailsMapper.mapFromEntityToMovieDetails(movieDetails)
        }

    private suspend fun saveMovieDetailsToDb(movieDetails: MovieDetails) =
        withContext(Dispatchers.IO) {
            val movieDetailsEntity = movieDetailsMapper.mapFromMovieDetailsToEntity(movieDetails)
            movieDetailsDb.moviesDao.insertToMovieDetails(movieDetailsEntity)
        }

    private suspend fun loadActorsFromDb(movieId: Long): List<Actor> = withContext(Dispatchers.IO) {
        val actorsList = movieDetailsDb.moviesDao.getActorsById(movieId)
        actorsListMapper.mapFromEntityToActorsList(actorsList)
    }

    private suspend fun saveActorsToDb(actorsList: List<Actor>) = withContext(Dispatchers.IO) {
        val actorsListEntity = actorsListMapper.mapFromActorsListToEntity(actorsList)
        movieDetailsDb.moviesDao.insertToActors(actorsListEntity)
    }

//    private suspend fun loadMovieDetailsWithActors(movieId: Long): MovieDetails = withContext(Dispatchers.IO) {
//        val movieDetailsWithActors = movieDetailsDb.moviesDao.getMovieDetailsWithActors(movieId)
//        movieDetailsMapper.mapFromMovieDetailsWithActorsToMovieDetails(movieDetailsWithActors)
//    }
}