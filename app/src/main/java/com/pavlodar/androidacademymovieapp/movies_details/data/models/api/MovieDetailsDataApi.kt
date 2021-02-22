package com.pavlodar.androidacademymovieapp.movies_details.data.models.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieDetailsDataApi (
    val adult: Boolean?,

    @SerialName("backdrop_path")
    val backdropPath: String?,

    @SerialName("belongs_to_collection")
    val belongsToCollectionApi: BelongsToCollectionApi?,

    val budget: Long?,

    @SerialName("genres")
    val genreApis: List<GenreDetailsApi>?,
    val homepage: String?,
    val id: Long?,

    @SerialName("imdb_id")
    val imdbID: String?,

    @SerialName("original_language")
    val originalLanguage: String?,

    @SerialName("original_title")
    val originalTitle: String?,

    val overview: String?,
    val popularity: Double?,

    @SerialName("poster_path")
    val posterPath: String?,

    @SerialName("production_companies")
    val productionCompanyApis: List<ProductionCompanyApi>?,

    @SerialName("production_countries")
    val productionCountryApis: List<ProductionCountryApi>?,

    @SerialName("release_date")
    val releaseDate: String?,

    val revenue: Long?,
    val runtime: Long?,

    @SerialName("spoken_languages")
    val spokenLanguageApis: List<SpokenLanguageApi>?,

    val status: String?,
    val tagline: String?,
    val title: String?,
    val video: Boolean?,

    @SerialName("vote_average")
    val voteAverage: Double?,

    @SerialName("vote_count")
    val voteCount: Long?
)
