package com.pavlodar.androidacademymovieapp.common.utils.mappers

import com.pavlodar.androidacademymovieapp.movies_list.data.models.GenreData
import com.pavlodar.androidacademymovieapp.movies_list.data.models.MovieApiData
import com.pavlodar.androidacademymovieapp.movies_list.data.models.MovieData

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

class MovieApiMapper {

    fun mapToListMovieData(movieApiData: List<MovieApiData>?, genresList: List<GenreData>): List<MovieData> {
        movieApiData ?: return emptyList()

//        val genresList = loadGenres(context)
        val genresMap = genresList.associateBy(GenreData::id)

        return movieApiData.map {

            MovieData(
                id = it.id ?: DEFAULT_MOVIE_ID,
                pgAge = if (it.adult!!) 16 else 13 ?: DEFAULT_MOVIE_PG_AGE,
                backdropPath = it.backdropPath ?: DEFAULT_MOVIE_BACKDROP_PATH,
                genreIDS = it.genreIDS!!.map { id ->
                    genresMap[id.toInt()] ?: error("")
                },
                originalLanguage = it.originalLanguage ?: DEFAULT_MOVIE_ORIG_LANG,
                originalTitle = it.originalTitle ?: DEFAULT_MOVIE_ORIG_TITLE,
                overview = it.overview ?: DEFAULT_MOVIE_OVERVIEW,
                popularity = it.popularity ?: DEFAULT_MOVIE_POPULARITY,
                posterPath = it.posterPath ?: DEFAULT_MOVIE_POSTER_PATH,
                releaseDate = it.releaseDate ?: DEFAULT_MOVIE_RELEASE_DATE,
                title = it.title ?: DEFAULT_MOVIE_TITLE,
                video = it.video ?: DEFAULT_MOVIE_VIDEO,
                raiting = (it.voteAverage?.div(2))?.toFloat() ?: DEFAULT_MOVIE_VOTE_AVERAGE,
                voteCount = it.voteCount ?: DEFAULT_MOVIE_VOTE_COUNT
            )
        }
    }
}