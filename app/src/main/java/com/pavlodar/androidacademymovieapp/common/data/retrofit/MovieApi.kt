package com.pavlodar.androidacademymovieapp.common.data.retrofit

import com.pavlodar.androidacademymovieapp.movies_details.data.models.api.ActorsListApi
import com.pavlodar.androidacademymovieapp.movies_details.data.models.api.MovieDetailsApi
import com.pavlodar.androidacademymovieapp.movies_list.data.models.api.PagesApi
import retrofit2.http.GET
import retrofit2.http.Path

const val API_KEY = "b19d8c6cf6096d7b8944978debe877c9"

interface MovieApi {

    @GET("3/movie/top_rated?api_key=b19d8c6cf6096d7b8944978debe877c9&language=en-US&page=1")
    suspend fun getPages(): PagesApi


    @GET("3/movie/{movieId}?api_key=b19d8c6cf6096d7b8944978debe877c9&language=en-US")
    suspend fun getMovieDetails(@Path("movieId") movieId: Long) : MovieDetailsApi


    @GET("3/movie/{movieId}/credits?api_key=b19d8c6cf6096d7b8944978debe877c9&language=en-US&page=1")
    suspend fun getActors(@Path("movieId") movieId: Long) : ActorsListApi
}