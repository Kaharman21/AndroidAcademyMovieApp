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
import java.lang.StringBuilder

class MoviesListViewHolder(
    view: View,
    private val action: OnItemClickListener
) : RecyclerView.ViewHolder(view) {

    private val movieItem: View = view.findViewById(R.id.fragment_movies_list)
    private val moviePoster: ImageView = view.findViewById(R.id.fragment_movies_list_poster)
    private val minimumAge: TextView = view.findViewById(R.id.fragment_movies_list_minimum_age)
    private val favorite: ImageView = view.findViewById(R.id.fragment_movies_list_favorite)
    private val movieGenre: TextView = view.findViewById(R.id.fragment_movies_list_movie_genre)
    private val movieRating: RatingBar = view.findViewById(R.id.fragment_movies_list_rating)
    private val reviewsNumber: TextView =
        view.findViewById(R.id.fragment_movies_list_reviews_number)
    private val movieTitle: TextView = view.findViewById(R.id.fragment_movies_list_title)
    private val movieRuntime: TextView = view.findViewById(R.id.fragment_movies_list_runtime)

    fun onBind(movieData: Movie) {
        moviePoster.load(movieData.imageUrl){
            placeholder(R.drawable.avengers_movie)
        }
        minimumAge.text = "${movieData.pgAge}+"
        movieRating.rating = movieData.rating.toFloat()
        reviewsNumber.text = movieData.reviewCount.toString()
        movieTitle.text = movieData.title
        movieRuntime.text = "${movieData.runningTime} min"

        if (movieData.isLiked) {
            favorite.load(R.drawable.ic_favorite_filed)
        } else {
            favorite.load(R.drawable.ic_favorite_empty)
        }

        var st = StringBuilder()

        for (n in movieData.genres.indices) {
            st.append(movieData.genres[n].name)
            if (n<movieData.genres.size-1){
                st.append(", ")
            }
        }
        movieGenre.text = st

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