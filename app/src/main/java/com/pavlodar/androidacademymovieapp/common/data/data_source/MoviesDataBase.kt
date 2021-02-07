package com.pavlodar.androidacademymovieapp.common.data.data_source

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.pavlodar.androidacademymovieapp.common.data.data_source.DbContract.DATABASE_NAME
import com.pavlodar.androidacademymovieapp.movies_list.data.models.db.MoviesListEntity
import com.pavlodar.androidacademymovieapp.common.domain.MoviesDao
import com.pavlodar.androidacademymovieapp.movies_details.data.models.db.MovieDetailsEntity

@Database(entities = [MoviesListEntity::class, MovieDetailsEntity::class], version = 1)
abstract class MoviesDataBase: RoomDatabase() {

    abstract val moviesDao: MoviesDao

    companion object{
        fun create(appContext: Context): MoviesDataBase = Room.databaseBuilder(
            appContext,
            MoviesDataBase::class.java,
            DATABASE_NAME
        ).fallbackToDestructiveMigration()
            .build()
    }
}