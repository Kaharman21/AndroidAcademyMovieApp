package com.pavlodar.androidacademymovieapp.movies_list.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable

data class PagesApi (
    val page: Long,
    val results: List<MovieApiData>,

    @SerialName("total_pages")
    val totalPages: Long,

    @SerialName("total_results")
    val totalResults: Long
)