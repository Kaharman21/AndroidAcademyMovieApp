package com.pavlodar.androidacademymovieapp.common.utils.mappers

import com.pavlodar.androidacademymovieapp.movies_list.data.models.GenreData
import java.lang.StringBuilder


fun genreToString(genreData: List<GenreData>?): String {
    genreData ?: emptyList()
    val st = StringBuilder()

    for (n in genreData!!.indices) {
        st.append(genreData[n].name)
        if (n < genreData.size - 1) {
            st.append(",")
        }
    }
    return st.toString()
}

fun stringToGenre(genreString: String?): List<GenreData>{
    genreString ?: return emptyList()

    val stringsList = genreString.split(",")
    val genresList = mutableListOf<GenreData>()
    for (n in stringsList.indices) {
        genresList.add(GenreData(n, stringsList[n]))
    }
    return genresList
}