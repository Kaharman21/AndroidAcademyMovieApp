package com.pavlodar.androidacademymovieapp.common.data.data_source

import androidx.room.TypeConverter
import com.pavlodar.androidacademymovieapp.movies_list.data.models.GenreData

//class Converters {
//
//    @TypeConverter
//    fun toGenresListOfStrings(genresListString: String): List<GenreData> {
//        val stringsList = genresListString.split(",")
//        val genresList = mutableListOf<GenreData>()
//        for (n in stringsList.indices) {
//            genresList.add(GenreData(n, stringsList[n]))
//        }
//        return genresList
//    }
//    @TypeConverter
//    fun genresListToString(genresList: List<String>): String {
//        return genresList.joinToString(",")
//    }
//
//}