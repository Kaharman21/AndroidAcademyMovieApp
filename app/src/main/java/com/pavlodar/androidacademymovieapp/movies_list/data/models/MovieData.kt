package com.pavlodar.androidacademymovieapp.movies_list.data.models

import kotlinx.serialization.SerialName

class MovieData(
    val id: Long,
    val pgAge: Int,
    val genresList: List<GenreData>,
    val posterPath: String,
    val title: String,
    val rating: Float,             // rating - voteAverage
    val voteCount: Long             // количество голосов
)
