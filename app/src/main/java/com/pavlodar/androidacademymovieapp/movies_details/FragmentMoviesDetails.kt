package com.pavlodar.androidacademymovieapp.movies_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pavlodar.androidacademymovieapp.R
import com.pavlodar.androidacademymovieapp.common.presentation.view.BaseFragment
import com.pavlodar.androidacademymovieapp.movies_details.presentation.view.MoviesDetailsAdapter
import com.pavlodar.androidacademymovieapp.movies_list.data.model.Actor

class FragmentMoviesDetails : BaseFragment(R.layout.fragment_movies_details) {

    private lateinit var recyclerView: RecyclerView
    private lateinit var moviePoster: ImageView
    private lateinit var favoriteImage: ImageView
    private lateinit var minimumAge: TextView
    private lateinit var movieTitle: TextView
    private lateinit var movieGenre: TextView

    private var adapter: MoviesDetailsAdapter = MoviesDetailsAdapter()
    private var actorList: List<Actor> = listOf()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        actorMockData()

        initViews(view)

        recyclerView = view.findViewById(R.id.fragment_movies_details_recycler_view)
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = adapter
        adapter.setData(actorList)
    }

    private fun initViews(view: View) {
        moviePoster = view.findViewById(R.id.fragment_movies_details_background_image)
        favoriteImage = view.findViewById(R.id.fragment_movies_details_favorite)
        minimumAge = view.findViewById(R.id.fragment_movies_details_age_limitation)
        movieTitle = view.findViewById(R.id.fragment_movies_details_movie_title)
        movieGenre = view.findViewById(R.id.fragment_movies_details_movie_genre)
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