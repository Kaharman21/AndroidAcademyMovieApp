package com.pavlodar.androidacademymovieapp.movies_details.data.models.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ActorsListApi (
    val id: Long,
    val cast: List<ActorOneApi>,
)

@Serializable
data class ActorOneApi (
    val adult: Boolean,
    val gender: Long,
    val id: Long,
    val name: String,

    @SerialName("original_name")
    val originalName: String,

    val popularity: Double,

    @SerialName("profile_path")
    val profilePath: String? = null,

    @SerialName("cast_id")
    val castID: Long? = null,

    val character: String? = null,

    @SerialName("credit_id")
    val creditID: String,

    val order: Long? = null,
    val job: String? = null
)