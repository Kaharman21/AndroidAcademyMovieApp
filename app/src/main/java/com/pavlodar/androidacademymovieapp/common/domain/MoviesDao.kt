package com.pavlodar.androidacademymovieapp.common.domain

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pavlodar.androidacademymovieapp.movies_details.data.models.db.MovieDetailsEntity
import com.pavlodar.androidacademymovieapp.movies_list.data.models.db.MoviesListEntity


@Dao
interface MoviesDao {

    @Query("SELECT * FROM movies_list_table")
    suspend fun getAllMovies(): List<MoviesListEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertToMoviesList(moviesListEntity: MoviesListEntity)

    @Query("SELECT * FROM movies_details_table")
    suspend fun getMoviesDetails(): MovieDetailsEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertToMovieDetails(movieDetailsEntity: MovieDetailsEntity)

    @Query("SELECT * FROM movies_list_table")
    suspend fun getActors(): List<MoviesListEntity>
}



