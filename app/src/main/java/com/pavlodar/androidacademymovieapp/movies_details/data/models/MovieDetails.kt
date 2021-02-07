package com.pavlodar.androidacademymovieapp.movies_details.data.models

import com.pavlodar.androidacademymovieapp.movies_details.data.models.api.*
import com.pavlodar.androidacademymovieapp.movies_list.data.models.GenreData

data class MovieDetails (
    val minimumAge: Int,   // adult
//    val backdropPath: String,
//    val belongsToCollectionApi: BelongsToCollection,
//    val budget: Long,
    val genreApis: List<GenreData>,
//    val homepage: String,
    val id: Long,
//    val imdbID: String,
//    val originalLanguage: String,
//    val originalTitle: String,
    val overview: String,
//    val popularity: Double,
    val posterPath: String,
//    val productionCompanyApis: List<ProductionCompanyApi>,
//    val productionCountryApis: List<ProductionCountryApi>,
//    val releaseDate: String,
//    val revenue: Long,
//    val runtime: Long,
//    val spokenLanguageApis: List<SpokenLanguageApi>,
//    val status: String,
//    val tagline: String,
    val title: String,
//    val video: Boolean,
    val voteAverage: Float,
    val voteCount: Long
)
