package com.pavlodar.androidacademymovieapp.movies_details.data.models.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.pavlodar.androidacademymovieapp.common.data.data_source.DbContract.MOVIES_DETAILS_TABLE_NAME
import com.pavlodar.androidacademymovieapp.movies_details.data.models.api.GenreDetailsApi

@Entity(tableName = MOVIES_DETAILS_TABLE_NAME)
class MovieDetailsEntity (
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Long,
    @ColumnInfo(name = "minimumAge")
    val minimumAge: Int,   // adult
    @ColumnInfo(name = "genresName")
    val genresName: String,
    @ColumnInfo(name = "overview")
    val overview: String,
    @ColumnInfo(name = "posterPath")
    val posterPath: String,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "voteAverage")
    val voteAverage: Float,
    @ColumnInfo(name = "voteCount")
    val voteCount: Long
)