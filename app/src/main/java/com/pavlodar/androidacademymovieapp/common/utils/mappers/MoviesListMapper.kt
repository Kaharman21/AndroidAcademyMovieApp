package com.pavlodar.androidacademymovieapp.common.utils.mappers

import com.pavlodar.androidacademymovieapp.movies_list.data.models.*
import com.pavlodar.androidacademymovieapp.movies_list.data.models.api.MovieApiData
import com.pavlodar.androidacademymovieapp.movies_list.data.models.db.MoviesListEntity
import java.lang.StringBuilder

private const val DEFAULT_MOVIE_ID = 0L
private const val DEFAULT_MOVIE_PG_AGE = 13
private const val DEFAULT_MOVIE_BACKDROP_PATH = ""
private val DEFAULT_MOVIE_GENRE_IDS = emptyList<Int>()
private const val DEFAULT_MOVIE_ORIG_LANG = ""
private const val DEFAULT_MOVIE_ORIG_TITLE = ""
private const val DEFAULT_MOVIE_OVERVIEW = ""
private const val DEFAULT_MOVIE_POPULARITY = 0.0
private const val DEFAULT_MOVIE_POSTER_PATH = ""
private const val DEFAULT_MOVIE_RELEASE_DATE = ""
private const val DEFAULT_MOVIE_TITLE = ""
private const val DEFAULT_MOVIE_VIDEO = false
private const val DEFAULT_MOVIE_VOTE_AVERAGE = 0F
private const val DEFAULT_MOVIE_VOTE_COUNT = 0L

private const val DEFAULT_PG_AGE = 0
private const val DEFAULT_ID = 0L

class MoviesListMapper {

    fun mapToListMovieData(movieApiData: List<MovieApiData>?, genresList: List<GenreData>): List<MovieData> {
        movieApiData ?: return emptyList()

        val genresMap = genresList.associateBy(GenreData::id)

        return movieApiData.map {

            MovieData(
                id = it.id ?: DEFAULT_MOVIE_ID,
                pgAge = if (it.adult!!) 16 else 13 ?: DEFAULT_MOVIE_PG_AGE,
                genresList = it.genreIDS!!.map { id ->
                    genresMap[id.toInt()] ?: error("")
                },
                posterPath = it.posterPath ?: DEFAULT_MOVIE_POSTER_PATH,
                title = it.title ?: DEFAULT_MOVIE_TITLE,
                rating = (it.voteAverage?.div(2))?.toFloat() ?: DEFAULT_MOVIE_VOTE_AVERAGE,
                voteCount = it.voteCount ?: DEFAULT_MOVIE_VOTE_COUNT
            )
        }
    }


    fun mapToMoviesEntity(movieData: MovieData): MoviesListEntity {
        return MoviesListEntity(
            id = movieData.id,
            pgAge = movieData.pgAge,
            genresName = genreToString(movieData.genresList),
            posterPath = movieData.posterPath,
            title = movieData.title,
            raiting = movieData.rating,
            voteCount = movieData.voteCount
        )
    }

    fun mapToMovieData(moviesListEntityList: List<MoviesListEntity>?): List<MovieData> {
        moviesListEntityList ?: emptyList()

        return moviesListEntityList!!.map {
            MovieData(
                id = it.id ?: DEFAULT_ID,
                pgAge = it.pgAge ?: DEFAULT_PG_AGE,
                genresList = stringToGenre(it.genresName),
                posterPath = it.posterPath,
                title = it.title,
                rating = it.raiting,
                voteCount = it.voteCount
            )
        }
    }

}