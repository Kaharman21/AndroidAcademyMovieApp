package com.pavlodar.androidacademymovieapp.movies_list.data.models

import kotlinx.serialization.SerialName

class MovieData(
    val id: Long,
    val pgAge: Int,
    val backdropPath: String,
    val genreIDS: List<GenreData>,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
    val title: String,
    val video: Boolean,
    val raiting: Float,             // raiting - voteAverage
    val voteCount: Long             // количество голосов
)