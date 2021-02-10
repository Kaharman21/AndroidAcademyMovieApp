package com.pavlodar.androidacademymovieapp.movies_details.data.models.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.pavlodar.androidacademymovieapp.common.data.data_source.DbContract.ACTORS_LIST_TABLE_NAME

@Entity(tableName = ACTORS_LIST_TABLE_NAME)
class ActorEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idBd")
    val idBd: Long = 0,
    @ColumnInfo(name = "movieId")
    val movieId: Long,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "profilePath")
    val profilePath: String,
    )