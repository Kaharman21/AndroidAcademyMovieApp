package com.pavlodar.androidacademymovieapp.movies_details.data.models

import com.pavlodar.androidacademymovieapp.movies_details.data.models.api.*
import com.pavlodar.androidacademymovieapp.movies_list.data.models.GenreData

data class MovieDetails (
    val minimumAge: Int,   // adult
    val genreApis: List<GenreData>,
    val id: Long,
    val overview: String,
    val posterPath: String,
    val title: String,
    val voteAverage: Float,
    val voteCount: Long,
val actors: List<Actor>
)
