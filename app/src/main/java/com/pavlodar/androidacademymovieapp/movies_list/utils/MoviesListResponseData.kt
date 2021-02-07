package com.pavlodar.androidacademymovieapp.movies_list.utils

sealed class MoviesListResponseData<out Result, out Error> {
    class Success<Result>(
        var response: Result
    ): MoviesListResponseData<Result, Nothing>()

    class Erroe<Error>(
        var error: Error
    ): MoviesListResponseData<Nothing, Error>()
}