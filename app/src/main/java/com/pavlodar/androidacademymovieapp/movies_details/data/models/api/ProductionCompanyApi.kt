package com.pavlodar.androidacademymovieapp.movies_details.data.models.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductionCompanyApi (
    val id: Long?,

    @SerialName("logo_path")
    val logoPath: String?,

    val name: String?,

    @SerialName("origin_country")
    val originCountry: String?
)