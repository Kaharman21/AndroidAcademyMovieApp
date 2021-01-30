package com.pavlodar.androidacademymovieapp.movies_details.data.retrofit

import com.pavlodar.androidacademymovieapp.movies_details.data.models.api.MovieDetailsDataApi
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieDetailsApi{

//    @GET("3/movie/761053?api_key=b19d8c6cf6096d7b8944978debe877c9&language=en-US")
//    suspend fun getMovieDetails() : MovieDetails

    @GET("3/movie/{movieId}?api_key=b19d8c6cf6096d7b8944978debe877c9&language=en-US")
    suspend fun getMovieDetails(@Path("movieId") movieId: Long) : MovieDetailsDataApi
}