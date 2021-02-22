package com.pavlodar.androidacademymovieapp.common.utils.mappers

import com.pavlodar.androidacademymovieapp.movies_details.data.models.*
import com.pavlodar.androidacademymovieapp.movies_details.data.models.api.GenreDetailsApi
import com.pavlodar.androidacademymovieapp.movies_details.data.models.api.MovieDetailsApi
import com.pavlodar.androidacademymovieapp.movies_details.data.models.db.MovieDetailsEntity
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
private const val DEFAULT_MOVIE_DETAILS_MINIMUM_AGE = 0

private const val DEFAULT_MOVIE_DETAILS_BELONGS_ID = 0L
private const val DEFAULT_MOVIE_DETAILS_BELONGS_NAME = ""
private const val DEFAULT_MOVIE_DETAILS_BELONGS_POSTER_PATH = ""
private const val DEFAULT_MOVIE_DETAILS_BELONGS_BACKDROP_PATH = ""

private const val DEFAULT_GENRE_ID = 0
private const val DEFAULT_GENRE_NAME = ""

class MovieDetailsMapper {

    private val actorsListMapper = ActorsListMapper()

    fun mapFromApiToMovieDetails(it: MovieDetailsApi?): MovieDetails{

        return MovieDetails(
            minimumAge = if (it?.adult!!) 16 else 13 ?: DEFAULT_MOVIE_DETAILS_ADULT,
//            backdropPath = it?.backdropPath ?: DEFAULT_MOVIE_DETAILS_BACKDROP_PATH,
//            belongsToCollectionApi = mapToBelongsToCollection(it?.belongsToCollectionApi),
//            budget = it?.budget ?: DEFAULT_MOVIE_DETAILS_BUDGET,
            genreApis = mapToGenreDataList(it.genreApis),
//            homepage = it?.homepage ?: DEFAULT_MOVIE_DETAILS_HOMEPAGE,
            id = it?.id ?: DEFAULT_MOVIE_DETAILS_ID,
//            imdbID = it?.imdbID ?: DEFAULT_MOVIE_DETAILS_IMDID,
//            originalLanguage = it?.originalLanguage ?: DEFAULT_MOVIE_DETAILS_ORIG_LANG,
//            originalTitle = it?.originalTitle ?: DEFAULT_MOVIE_DETAILS_ORIG_TITLE,
            overview = it?.overview ?: DEFAULT_MOVIE_DETAILS_OVERVIEW,
//            popularity = it?.popularity ?: DEFAULT_MOVIE_DETAILS_POPULARITY,
            posterPath = it?.posterPath ?: DEFAULT_MOVIE_DETAILS_POSTER_PATH,
//            productionCompanyApis = emptyList(), //it.productionCompanyApis!!,
//            productionCountryApis = emptyList(), //it.productionCountryApis!!,
//            releaseDate = it?.releaseDate ?: DEFAULT_MOVIE_DETAILS_RELEASE_DATE,
//            revenue = it?.revenue ?: DEFAULT_MOVIE_DETAILS_REVENUE,
//            runtime = it?.runtime ?: DEFAULT_MOVIE_DETAILS_RUNTIME,
//            spokenLanguageApis = emptyList(), //it.spokenLanguageApis!!,
//            status = it?.status ?: DEFAULT_MOVIE_DETAILS_STATUS,
//            tagline = it?.tagline ?: DEFAULT_MOVIE_DETAILS_TAGLINE,
            title = it?.title ?: DEFAULT_MOVIE_DETAILS_TITLE,
//            video = it?.video ?: DEFAULT_MOVIE_DETAILS_VIDEO,
            voteAverage =  (it.voteAverage?.div(2))?.toFloat() ?: DEFAULT_MOVIE_DETAILS_VOTE_AVERAGE,
            voteCount = it?.voteCount ?: DEFAULT_MOVIE_DETAILS_VOTE_COUNT,
            actors = emptyList()
        )
    }

//   private fun mapToBelongsToCollection(belongsToCollectionApi: BelongsToCollectionApi?): BelongsToCollection{
//        return BelongsToCollection(
//            id = belongsToCollectionApi?.id ?: DEFAULT_MOVIE_DETAILS_BELONGS_ID,
//            name = belongsToCollectionApi?.name ?: DEFAULT_MOVIE_DETAILS_BELONGS_NAME,
//            posterPath = belongsToCollectionApi?.posterPath ?: DEFAULT_MOVIE_DETAILS_BELONGS_POSTER_PATH,
//            backdropPath = belongsToCollectionApi?.backdropPath ?: DEFAULT_MOVIE_DETAILS_BELONGS_BACKDROP_PATH
//        )
//    }

    private fun mapToGenreDataList(genreDetailsApiList: List<GenreDetailsApi>?): List<GenreData>{
        genreDetailsApiList ?: emptyList()

        return genreDetailsApiList!!.map {
            GenreData(
                id = it.id?.toInt() ?: DEFAULT_GENRE_ID,
                name = it.name ?: DEFAULT_GENRE_NAME
            )
        }
    }

    private fun mapToGenreDetailsApiList(genreDataList: List<GenreData>): List<GenreDetailsApi>{
        genreDataList ?: emptyList()

        return genreDataList.map {
            GenreDetailsApi(
                id = it.id.toLong(),
                name = it.name
            )
        }
    }

    fun mapFromEntityToMovieDetails(movieDetailsEntity: MovieDetailsEntity?): MovieDetails{
        return MovieDetails(
            id = movieDetailsEntity?.id ?: DEFAULT_MOVIE_DETAILS_ID,
            minimumAge = movieDetailsEntity?.minimumAge ?: DEFAULT_MOVIE_DETAILS_MINIMUM_AGE,
            genreApis = stringToGenre(movieDetailsEntity?.genresName),
            overview = movieDetailsEntity?.overview ?: DEFAULT_MOVIE_DETAILS_OVERVIEW,
            posterPath = movieDetailsEntity?.posterPath ?: DEFAULT_MOVIE_DETAILS_POSTER_PATH,
            title = movieDetailsEntity?.title ?: DEFAULT_MOVIE_DETAILS_TITLE,
            voteAverage = movieDetailsEntity?.voteAverage ?: DEFAULT_MOVIE_DETAILS_VOTE_AVERAGE,
            voteCount = movieDetailsEntity?.voteCount ?: DEFAULT_MOVIE_DETAILS_VOTE_COUNT,
            actors = emptyList()
        )
    }

    fun mapFromMovieDetailsToEntity(movieDetails: MovieDetails?): MovieDetailsEntity{
        return MovieDetailsEntity(
            id = movieDetails?.id ?: DEFAULT_MOVIE_DETAILS_ID,
            minimumAge = movieDetails?.minimumAge ?: DEFAULT_MOVIE_DETAILS_MINIMUM_AGE,
            genresName = genreToString(movieDetails?.genreApis),
            overview = movieDetails?.overview ?: DEFAULT_MOVIE_DETAILS_OVERVIEW,
            posterPath = movieDetails?.posterPath ?: DEFAULT_MOVIE_DETAILS_POSTER_PATH,
            title = movieDetails?.title ?: DEFAULT_MOVIE_DETAILS_TITLE,
            voteAverage = movieDetails?.voteAverage ?: DEFAULT_MOVIE_DETAILS_VOTE_AVERAGE,
            voteCount = movieDetails?.voteCount ?: DEFAULT_MOVIE_DETAILS_VOTE_COUNT
        )
    }

//    fun mapFromMovieDetailsWithActorsToMovieDetails(movieDetailsWithActors: MovieDetailsWithActors): MovieDetails{
//        return MovieDetails(
//            id = movieDetailsWithActors?.id ?: DEFAULT_MOVIE_DETAILS_ID,
//            minimumAge = movieDetailsWithActors?.minimumAge ?: DEFAULT_MOVIE_DETAILS_MINIMUM_AGE,
//            genreApis = stringToGenre(movieDetailsWithActors?.genresName),
//            overview = movieDetailsWithActors?.overview ?: DEFAULT_MOVIE_DETAILS_OVERVIEW,
//            posterPath = movieDetailsWithActors?.posterPath ?: DEFAULT_MOVIE_DETAILS_POSTER_PATH,
//            title = movieDetailsWithActors?.title ?: DEFAULT_MOVIE_DETAILS_TITLE,
//            voteAverage = movieDetailsWithActors?.voteAverage ?: DEFAULT_MOVIE_DETAILS_VOTE_AVERAGE,
//            voteCount = movieDetailsWithActors?.voteCount ?: DEFAULT_MOVIE_DETAILS_VOTE_COUNT,
//            actors = actorsListMapper.mapFromEntityToActorsList(movieDetailsWithActors.actors)
//        )
//    }


}