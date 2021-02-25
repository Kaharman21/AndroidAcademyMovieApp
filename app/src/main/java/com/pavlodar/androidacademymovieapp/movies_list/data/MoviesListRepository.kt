package com.pavlodar.androidacademymovieapp.movies_list.data

import android.app.Application
import android.content.Context
import com.pavlodar.androidacademymovieapp.common.data.retrofit.RetrofitClient
import com.pavlodar.androidacademymovieapp.movies_list.data.models.GenreJson
import com.pavlodar.androidacademymovieapp.movies_list.data.models.GenreData
import com.pavlodar.androidacademymovieapp.movies_list.data.models.MovieData
import com.pavlodar.androidacademymovieapp.common.utils.mappers.MoviesListMapper
import com.pavlodar.androidacademymovieapp.common.data.data_source.MoviesDataBase
import com.pavlodar.androidacademymovieapp.common.extensions.showToast
import kotlinx.coroutines.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.lang.Exception

class MoviesListRepository(
    private val application: Application
) {

    private val jsonFormat = Json { ignoreUnknownKeys = true }
    private val movieApiMapper = MoviesListMapper()
    private val moviesListMapper = MoviesListMapper()

    private val moviesListDb = MoviesDataBase.create(application)

    fun getMoviesList(
        result: (List<MovieData>) -> Unit,
        fail: (String) -> Unit,
        coroutineScope: CoroutineScope
    ) {
        coroutineScope.launch {
            try {
                val moviesListFromDb = loadDataFromDb()
                result(moviesListFromDb)

                val moviesListFromApi = loadDataFromApi()
                saveMoviesListToDb(moviesListFromApi)
                result(moviesListFromApi)

            } catch (e: Exception) {
                fail(e.localizedMessage)
            }
        }
    }

    suspend fun updateMoviesListInDb() = withContext(Dispatchers.IO){
        deleteAllFromMoviesList()
        val moviesListFromApi = loadDataFromApi()
        saveMoviesListToDb(moviesListFromApi)
    }

    private suspend fun deleteAllFromMoviesList() = withContext(Dispatchers.IO){
        moviesListDb.moviesDao.deleteAllFromMoviesList()
    }

    private suspend fun loadDataFromApi(): List<MovieData> = withContext(Dispatchers.IO) {
        val pagesApiResponse = RetrofitClient.moviesApi.getPages()
        val moviesListApi = pagesApiResponse.moviesList
        val genresList = loadGenresFromAssets(application)
        movieApiMapper.mapToListMovieData(moviesListApi, genresList)
    }

    private suspend fun loadDataFromDb(): List<MovieData> = withContext(Dispatchers.IO) {
        val moviesListEntity = moviesListDb.moviesDao.getAllMovies()
        moviesListMapper.mapToMovieData(moviesListEntity)
    }

    private suspend fun saveMoviesListToDb(moviesList: List<MovieData>) = withContext(Dispatchers.IO){
        moviesList.forEach {
            moviesListDb.moviesDao.insertToMoviesList(moviesListMapper.mapToMoviesEntity(it))
        }
    }

    private fun loadGenresFromAssets(context: Context): List<GenreData> {
        val data = readAssetFileToString(context, "genres.json")
        return parseGenresNew(data)
    }

    private fun readAssetFileToString(context: Context, fileName: String): String {
        val stream = context.assets.open(fileName)
        return stream.bufferedReader().readText()
    }

    private fun parseGenresNew(jsonString: String): List<GenreData> {
        val jsonGenres = jsonFormat.decodeFromString<List<GenreJson>>(jsonString)
        return jsonGenres.map { jsonGenre -> GenreData(id = jsonGenre.id, name = jsonGenre.name) }
    }
}