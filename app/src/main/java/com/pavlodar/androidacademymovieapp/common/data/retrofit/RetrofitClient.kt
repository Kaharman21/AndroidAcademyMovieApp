package com.pavlodar.androidacademymovieapp.common.data.retrofit

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.pavlodar.androidacademymovieapp.movies_details.data.retrofit.MovieDetailsApi
import com.pavlodar.androidacademymovieapp.movies_list.data.retrofit.MoviesListApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.create

private const val BASE_URL = "https://api.themoviedb.org/"

object RetrofitClient{
    private val json = Json{
        ignoreUnknownKeys = true
    }

    private val contentType = "application/json".toMediaType()
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(json.asConverterFactory(contentType))
        .build()

    val moviesListApi: MoviesListApi = retrofit.create()
//    val movieDetailsApi: MovieDetailsApi = retrofit.create()
}

object RetrofitClientTwo{
    private val json = Json{
        ignoreUnknownKeys = true
    }

    private val contentType = "application/json".toMediaType()
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(json.asConverterFactory(contentType))
        .build()

    val movieDetailsApi: MovieDetailsApi = retrofit.create()
}