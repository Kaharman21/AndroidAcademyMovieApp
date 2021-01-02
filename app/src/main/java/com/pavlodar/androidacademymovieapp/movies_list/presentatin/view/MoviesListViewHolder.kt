package com.pavlodar.androidacademymovieapp.movies_list.presentatin.view

import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.pavlodar.androidacademymovieapp.R
import com.pavlodar.androidacademymovieapp.movies_details.FragmentMoviesDetails
import com.pavlodar.androidacademymovieapp.movies_list.data.model.Movie

class MoviesListViewHolder(
    view: View,
    private val action: OnItemClickListener
    ) : RecyclerView.ViewHolder(view) {

    val movieItem: View = view.findViewById(R.id.fragment_movies_list)
    val moviePoster: ImageView = view.findViewById(R.id.fragment_movies_list_poster)
    val minimumAge: TextView = view.findViewById(R.id.fragment_movies_list_minimum_age)
    val favorite: ImageView = view.findViewById(R.id.fragment_movies_list_favorite)
    val movieGenre: TextView = view.findViewById(R.id.fragment_movies_list_movie_genre)
    val movieRating: RatingBar = view.findViewById(R.id.fragment_movies_list_rating)
    val reviewsNumber: TextView = view.findViewById(R.id.fragment_movies_list_reviews_number)
    val movieTitle: TextView = view.findViewById(R.id.fragment_movies_list_title)
    val movieRuntime: TextView = view.findViewById(R.id.fragment_movies_list_runtime)


    fun onBind(movieData: Movie) {
        moviePoster.load(R.drawable.avengers_movie)
        minimumAge.text = "Salam"
        movieGenre.text = "21+"

        setupListeners()
    }

    private fun setupListeners() {
        movieItem.setOnClickListener {
            action.onMovieItemClick()
        }
    }
}

interface OnItemClickListener {
    fun onMovieItemClick()
}