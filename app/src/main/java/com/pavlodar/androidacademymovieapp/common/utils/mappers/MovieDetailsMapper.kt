package com.pavlodar.androidacademymovieapp.common.utils.mappers

import com.pavlodar.androidacademymovieapp.movies_details.data.models.*
import com.pavlodar.androidacademymovieapp.movies_details.data.models.api.BelongsToCollectionApi
import com.pavlodar.androidacademymovieapp.movies_details.data.models.api.MovieDetailsDataApi
import com.pavlodar.androidacademymovieapp.movies_list.data.models.GenreData

private const val DEFAULT_MOVIE_DETAILS_ADULT = 0
private const val DEFAULT_MOVIE_DETAILS_BACKDROP_PATH = ""
private const val DEFAULT_MOVIE_DETAILS_BUDGET = 0L
private const val DEFAULT_MOVIE_DETAILS_HOMEPAGE = ""
private const val DEFAULT_MOVIE_DETAILS_ID = 0L
private const val DEFAULT_MOVIE_DETAILS_IMDID = ""
private const val DEFAULT_MOVIE_DETAILS_ORIG_LANG = ""
private const val DEFAULT_MOVIE_DETAILS_ORIG_TITLE = ""
private const val DEFAULT_MOVIE_DETAILS_OVERVIEW = ""
private const val DEFAULT_MOVIE_DETAILS_POPULARITY = 0.0
private const val DEFAULT_MOVIE_DETAILS_POSTER_PATH = ""
private const val DEFAULT_MOVIE_DETAILS_RELEASE_DATE = ""
private const val DEFAULT_MOVIE_DETAILS_REVENUE = 0L
private const val DEFAULT_MOVIE_DETAILS_RUNTIME = 0L
private const val DEFAULT_MOVIE_DETAILS_STATUS = ""
private const val DEFAULT_MOVIE_DETAILS_TAGLINE = ""
private const val DEFAULT_MOVIE_DETAILS_TITLE = ""
private const val DEFAULT_MOVIE_DETAILS_VIDEO = false
private const val DEFAULT_MOVIE_DETAILS_VOTE_AVERAGE = 0F
private const val DEFAULT_MOVIE_DETAILS_VOTE_COUNT = 0L

private const val DEFAULT_MOVIE_DETAILS_BELONGS_ID = 0L
private const val DEFAULT_MOVIE_DETAILS_BELONGS_NAME = ""
private const val DEFAULT_MOVIE_DETAILS_BELONGS_POSTER_PATH = ""
private const val DEFAULT_MOVIE_DETAILS_BELONGS_BACKDROP_PATH = ""

class MovieDetailsMapper {

    fun mapToMovieDetails(it: MovieDetailsDataApi?): MovieDetails{

        return MovieDetails(
            minimumAge = if (it?.adult!!) 16 else 13 ?: DEFAULT_MOVIE_DETAILS_ADULT,
            backdropPath = it?.backdropPath ?: DEFAULT_MOVIE_DETAILS_BACKDROP_PATH,
            belongsToCollectionApi = mapToBelongsToCollection(it?.belongsToCollectionApi),
            budget = it?.budget ?: DEFAULT_MOVIE_DETAILS_BUDGET,
//            genreApis = it?.genreApis!!.map {
//                genresMap[it.id?.toInt()]?: error("")
//            },
            genreApis = it?.genreApis!!,
            homepage = it?.homepage ?: DEFAULT_MOVIE_DETAILS_HOMEPAGE,
            id = it?.id ?: DEFAULT_MOVIE_DETAILS_ID,
            imdbID = it?.imdbID ?: DEFAULT_MOVIE_DETAILS_IMDID,
            originalLanguage = it?.originalLanguage ?: DEFAULT_MOVIE_DETAILS_ORIG_LANG,
            originalTitle = it?.originalTitle ?: DEFAULT_MOVIE_DETAILS_ORIG_TITLE,
            overview = it?.overview ?: DEFAULT_MOVIE_DETAILS_OVERVIEW,
            popularity = it?.popularity ?: DEFAULT_MOVIE_DETAILS_POPULARITY,
            posterPath = it?.posterPath ?: DEFAULT_MOVIE_DETAILS_POSTER_PATH,
            productionCompanyApis = emptyList(), //it.productionCompanyApis!!,
            productionCountryApis = emptyList(), //it.productionCountryApis!!,
            releaseDate = it?.releaseDate ?: DEFAULT_MOVIE_DETAILS_RELEASE_DATE,
            revenue = it?.revenue ?: DEFAULT_MOVIE_DETAILS_REVENUE,
            runtime = it?.runtime ?: DEFAULT_MOVIE_DETAILS_RUNTIME,
            spokenLanguageApis = emptyList(), //it.spokenLanguageApis!!,
            status = it?.status ?: DEFAULT_MOVIE_DETAILS_STATUS,
            tagline = it?.tagline ?: DEFAULT_MOVIE_DETAILS_TAGLINE,
            title = it?.title ?: DEFAULT_MOVIE_DETAILS_TITLE,
            video = it?.video ?: DEFAULT_MOVIE_DETAILS_VIDEO,
            voteAverage =  (it.voteAverage?.div(2))?.toFloat() ?: DEFAULT_MOVIE_DETAILS_VOTE_AVERAGE ,
            voteCount = it?.voteCount ?: DEFAULT_MOVIE_DETAILS_VOTE_COUNT
        )
    }

   private fun mapToBelongsToCollection(belongsToCollectionApi: BelongsToCollectionApi?): BelongsToCollection{
        return BelongsToCollection(
            id = belongsToCollectionApi?.id ?: DEFAULT_MOVIE_DETAILS_BELONGS_ID,
            name = belongsToCollectionApi?.name ?: DEFAULT_MOVIE_DETAILS_BELONGS_NAME,
            posterPath = belongsToCollectionApi?.posterPath ?: DEFAULT_MOVIE_DETAILS_BELONGS_POSTER_PATH,
            backdropPath = belongsToCollectionApi?.backdropPath ?: DEFAULT_MOVIE_DETAILS_BELONGS_BACKDROP_PATH
        )
    }
}