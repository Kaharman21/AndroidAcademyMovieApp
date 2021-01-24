package com.pavlodar.androidacademymovieapp.movies_details

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.pavlodar.androidacademymovieapp.R
import com.pavlodar.androidacademymovieapp.common.presentation.views.BaseFragment
import com.pavlodar.androidacademymovieapp.data.loadMovies
import com.pavlodar.androidacademymovieapp.movies_details.presentation.views.MoviesDetailsAdapter
import com.pavlodar.androidacademymovieapp.movies_list.data.models.Actor
import com.pavlodar.androidacademymovieapp.movies_list.data.models.Movie
import java.lang.StringBuilder

class FragmentMoviesDetails(movieId: Int, private val movie: Movie) :
    BaseFragment(R.layout.fragment_movies_details) {

    private lateinit var recyclerView: RecyclerView
    private lateinit var moviePoster: ImageView
    private lateinit var favoriteImage: ImageView
    private lateinit var minimumAge: TextView
    private lateinit var movieTitle: TextView
    private lateinit var movieGenre: TextView
    private lateinit var rating: RatingBar
    private lateinit var storylineTitle: TextView
    private lateinit var storylineText: TextView

    private var adapter: MoviesDetailsAdapter = MoviesDetailsAdapter()
    private var actorList: List<Actor> = listOf()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        actorMockData()

        initViews(view)
        handleData()
//        adapter.setData(actorList)
        adapter.setData(movie.actors)
    }

    private fun handleData() {
        moviePoster.load(movie.imageUrl){
            placeholder(R.drawable.ic_favorite_filed)
        }
        minimumAge.text = movie.pgAge.toString()
        movieTitle.text = movie.title
        rating.rating = movie.rating.toFloat()
        storylineText.text = movie.storyLine

        handleFavorite()

        var st = StringBuilder()

        for (n in movie.genres.indices) {
            st.append(movie.genres[n].name)
            if (n<movie.genres.size-1){
                st.append(", ")
            }
        }
        movieGenre.text = st
    }

    private fun handleFavorite(){
        if (movie.isLiked) {
            favoriteImage.load(R.drawable.ic_favorite_filed)
        } else {
            favoriteImage.load(R.drawable.ic_favorite_empty)
        }
    }

    private fun initViews(view: View) {
        moviePoster = view.findViewById(R.id.fragment_movies_details_background_image)
        favoriteImage = view.findViewById(R.id.fragment_movies_details_favorite)
        minimumAge = view.findViewById(R.id.fragment_movies_details_age_limitation)
        movieTitle = view.findViewById(R.id.fragment_movies_details_movie_title)
        movieGenre = view.findViewById(R.id.fragment_movies_details_movie_genre)
        rating = view.findViewById(R.id.fragment_movies_details_rating)
        storylineTitle = view.findViewById(R.id.fragment_movies_details_storyline_title)
        storylineText = view.findViewById(R.id.fragment_movies_details_storyline_text)

        recyclerView = view.findViewById(R.id.fragment_movies_details_recycler_view)
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = adapter
    }

    private fun actorMockData() {
        actorList = listOf(
            Actor(1, "Hero-mero", ""),
            Actor(2, "sssss", ""),
            Actor(2, "sssss", ""),
            Actor(2, "sssss", ""),
            Actor(2, "sssss", "")
        )
    }
}