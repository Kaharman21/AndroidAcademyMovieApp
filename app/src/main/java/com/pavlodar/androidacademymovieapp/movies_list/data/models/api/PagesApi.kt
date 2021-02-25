package com.pavlodar.androidacademymovieapp.movies_list.data.models.api

import com.pavlodar.androidacademymovieapp.movies_list.data.models.api.MovieApiData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PagesApi (
    val page: Long,

    @SerialName("results")
    val moviesList: List<MovieApiData>,

    @SerialName("total_pages")
    val totalPages: Long,

    @SerialName("total_results")
    val totalResults: Long
)