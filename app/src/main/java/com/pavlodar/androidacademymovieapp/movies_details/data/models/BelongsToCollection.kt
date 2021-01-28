package com.pavlodar.androidacademymovieapp.movies_details.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BelongsToCollection (
    val id: Long,
    val name: String,

    @SerialName("poster_path")
    val posterPath: String,

    @SerialName("backdrop_path")
    val backdropPath: String
)