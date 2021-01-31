package com.pavlodar.androidacademymovieapp.movies_list.data

import android.app.Application
import android.content.Context
import com.pavlodar.androidacademymovieapp.common.data.retrofit.RetrofitClient
import com.pavlodar.androidacademymovieapp.data.models.JsonGenre
import com.pavlodar.androidacademymovieapp.movies_list.data.models.GenreData
import com.pavlodar.androidacademymovieapp.movies_list.data.models.MovieData
import com.pavlodar.androidacademymovieapp.common.utils.mappers.MovieApiMapper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.lang.Exception

class MoviesListRepository(
    private val application: Application
) {

    private val jsonFormat = Json { ignoreUnknownKeys = true }
    private val movieApiMapper = MovieApiMapper()

    fun getMoviesList(
        result: (List<MovieData>) -> Unit,
        fail: (String) -> Unit,
        coroutineScope: CoroutineScope
    ){
        try{
            coroutineScope.launch {
                val movieDetailsResponse = RetrofitClient.moviesListApi.getPages()
                val moviesListApi = movieDetailsResponse.results
                val genresList = loadGenres(application)
                val moviesList = movieApiMapper.mapToListMovieData(moviesListApi, genresList)
                result(moviesList)
            }
        } catch (e: Exception){
            fail(e.localizedMessage)
        }
    }

    private fun loadGenres(context: Context): List<GenreData> {
        val data = readAssetFileToString(context, "genres.json")
        return parseGenresNew(data)
    }

    private fun readAssetFileToString(context: Context, fileName: String): String {
        val stream = context.assets.open(fileName)
        return stream.bufferedReader().readText()
    }

    private fun parseGenresNew(jsonString: String): List<GenreData> {
        val jsonGenres = jsonFormat.decodeFromString<List<JsonGenre>>(jsonString)
        return jsonGenres.map { jsonGenre -> GenreData(id = jsonGenre.id, name = jsonGenre.name) }
    }
}