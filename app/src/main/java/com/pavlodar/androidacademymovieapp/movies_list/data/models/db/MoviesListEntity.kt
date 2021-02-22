package com.pavlodar.androidacademymovieapp.movies_list.data.models.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.pavlodar.androidacademymovieapp.common.data.data_source.DbContract.MOVIES_LIST_TABLE_NAME

@Entity(tableName = MOVIES_LIST_TABLE_NAME)
class MoviesListEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idBd")
    val idBd: Long = 0,

    @ColumnInfo(name = "id")
    val id: Long?,
    @ColumnInfo(name = "pgAge")
    val pgAge: Int?,
    @ColumnInfo(name = "genresName")           // +++++++++++
    val genresName: String,
    @ColumnInfo(name = "posterPath")
    val posterPath: String,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "raiting")
    val raiting: Float,             // raiting - voteAverage
    @ColumnInfo(name = "voteCount")
    val voteCount: Long             // количество голосов
)