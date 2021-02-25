package com.pavlodar.androidacademymovieapp.common.domain

import androidx.room.*
import com.pavlodar.androidacademymovieapp.movies_details.data.models.db.ActorEntity
import com.pavlodar.androidacademymovieapp.movies_details.data.models.db.MovieDetailsEntity
import com.pavlodar.androidacademymovieapp.movies_list.data.models.db.MoviesListEntity


@Dao
interface MoviesDao {

    @Query("SELECT * FROM movies_list_table")
    suspend fun getAllMovies(): List<MoviesListEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertToMoviesList(moviesListEntity: MoviesListEntity)

    @Query("DELETE FROM movies_list_table")
    suspend fun deleteAllFromMoviesList()

    @Query("SELECT * FROM movies_details_table WHERE id = :movieId")
    suspend fun getMoviesDetailsById(movieId: Long): MovieDetailsEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertToMovieDetails(movieDetailsEntity: MovieDetailsEntity)

    @Query("SELECT * FROM actors_list_table WHERE movieId = :movieId")
    suspend fun getActorsById(movieId: Long): List<ActorEntity>

//    @Transaction
//    @Query("SELECT * FROM movies_details_table WHERE id = :movieId")
//    suspend fun getMovieDetailsWithActors(movieId: Long): MovieDetailsWithActors

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertToActors(actorsListEntity: List<ActorEntity>)
}



