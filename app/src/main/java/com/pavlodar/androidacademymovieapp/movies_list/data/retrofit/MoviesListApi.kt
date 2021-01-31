package com.pavlodar.androidacademymovieapp.movies_list.data.retrofit

import com.pavlodar.androidacademymovieapp.movies_list.data.models.PagesApi
import retrofit2.http.GET

const val API_KEY = "b19d8c6cf6096d7b8944978debe877c9"

interface MoviesListApi {

    @GET("3/movie/top_rated?api_key=b19d8c6cf6096d7b8944978debe877c9&language=en-US&page=1")
    suspend fun getPages(): PagesApi
}