package com.pavlodar.androidacademymovieapp.movies_list.data.retrofit

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.create


//private const val BASE_URL = "https://api.themoviedb.org/"
//
//object MoviesListClient{
//    private val json = Json{
//        ignoreUnknownKeys = true
//    }
//
//    private val contentType = "application/json".toMediaType()
//    private val retrofit: Retrofit = Retrofit.Builder()
//        .baseUrl(BASE_URL)
//        .addConverterFactory(json.asConverterFactory(contentType))
//        .build()
//
//    val moviesListApi: MoviesListApi = retrofit.create()
//}