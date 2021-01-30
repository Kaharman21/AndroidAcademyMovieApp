package com.pavlodar.androidacademymovieapp.movies_details.data.models.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BelongsToCollectionApi (
    val id: Long?,
    val name: String?,

    @SerialName("poster_path")
    val posterPath: String?,

    @SerialName("backdrop_path")
    val backdropPath: String?
)