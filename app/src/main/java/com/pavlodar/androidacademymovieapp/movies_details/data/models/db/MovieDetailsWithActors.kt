package com.pavlodar.androidacademymovieapp.movies_details.data.models.db

import androidx.room.ColumnInfo
import androidx.room.Relation
import com.pavlodar.androidacademymovieapp.movies_details.data.models.api.Actor

//data class MovieDetailsWithActors (
//    val id: Long,   // adult
//    val minimumAge: Int,   // adult
//    val genresName: String,
//    val overview: String,
//    val posterPath: String,
//    val title: String,
//    val voteAverage: Float,
//    val voteCount: Long,
//
//    @Relation(parentColumn = "id", entityColumn = "movieId")
//    val actors: List<ActorEntity>
//)