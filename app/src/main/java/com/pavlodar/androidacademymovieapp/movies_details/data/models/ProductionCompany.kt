package com.pavlodar.androidacademymovieapp.movies_details.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductionCompany (
    val id: Long,

    @SerialName("logo_path")
    val logoPath: String,

    val name: String,

    @SerialName("origin_country")
    val originCountry: String
)