package com.pavlodar.androidacademymovieapp.movies_list.presentatin.views

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.pavlodar.androidacademymovieapp.R
import com.pavlodar.androidacademymovieapp.movies_list.data.models.MovieData

const val ADDRESS_FOR_IMAGE = "https://image.tmdb.org/t/p/w500"

class MoviesListViewHolder(
    view: View,
    private val action: OnMovieClickListener,
    private var context: Context
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

    fun onBind(movieData: MovieData) {
        moviePoster.load(ADDRESS_FOR_IMAGE + movieData.posterPath){
            placeholder(R.drawable.avengers_movie)
        }

//        Glide.with(context)
//            .load(movieData.imageUrl)
//            .into(moviePoster)

        minimumAge.text = "${movieData.pgAge}+"
        movieRating.rating = movieData.raiting
        reviewsNumber.text = movieData.voteCount.toString()
        movieTitle.text = movieData.title
//        movieRuntime.text = "${movieData.runningTime} min"

//        if (movieData.isLiked) {
//            favorite.load(R.drawable.ic_favorite_filed)
//        } else {
//            favorite.load(R.drawable.ic_favorite_empty)
//        }

        var st = StringBuilder()

        for (n in movieData.genreIDS.indices) {
            st.append(movieData.genreIDS[n].name)
            if (n<movieData.genreIDS.size-1){
                st.append(", ")
            }
        }
        movieGenre.text = st

        setupListeners(movieData.id)
    }

    private fun setupListeners(movieId: Long) {
        movieItem.setOnClickListener {
            action.onMovieItemClick(movieId = movieId)
        }
    }
}

interface OnMovieClickListener {
    fun onMovieItemClick(movieId: Long)
}