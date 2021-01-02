package com.pavlodar.androidacademymovieapp.movies_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pavlodar.androidacademymovieapp.R
import com.pavlodar.androidacademymovieapp.common.presentation.view.BaseFragment
import com.pavlodar.androidacademymovieapp.movies_details.FragmentMoviesDetails
import com.pavlodar.androidacademymovieapp.movies_list.data.model.Actor
import com.pavlodar.androidacademymovieapp.movies_list.data.model.Genre
import com.pavlodar.androidacademymovieapp.movies_list.data.model.Movie
import com.pavlodar.androidacademymovieapp.movies_list.presentatin.view.MoviesListAdapter
import com.pavlodar.androidacademymovieapp.movies_list.presentatin.view.OnItemClickListener

class FragmentMoviesList: BaseFragment(R.layout.fragment_movies_list), OnItemClickListener{

    private lateinit var recyclerView: RecyclerView

    private var adapter = MoviesListAdapter(this)
    private var moviesData: List<Movie>? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.fragment_movies_list_recycler_view)
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        recyclerView.adapter = adapter

        moviesMockData()
    }

    override fun onMovieItemClick() {
        goToFragmentMoviesDetails()
    }

    private fun moviesMockData(){
        moviesData = listOf(
            Movie(
                0, "aaaa", "", "", "", 2.0f,
                1, 1, 2, listOf(Genre(1, "2")),
                listOf(Actor(1, "",""))
            ),
            Movie(
                0, "aaaa", "", "", "", 2.0f,
                1, 1, 2, listOf(Genre(1, "2")),
                listOf(Actor(1, "",""))
            ),
            Movie(
                0, "aaaa", "", "", "", 2.0f,
                1, 1, 2, listOf(Genre(1, "2")),
                listOf(Actor(1, "",""))
            ),
            Movie(
                0, "aaaa", "", "", "", 2.0f,
                1, 1, 2, listOf(Genre(1, "2")),
                listOf(Actor(1, "",""))
            )
        )
        adapter.setData(moviesData!!)
    }

    private fun goToFragmentMoviesDetails() {
        fragmentManager?.beginTransaction()
            ?.addToBackStack(null)
            ?.replace(
                R.id.main_activity_container,
                FragmentMoviesDetails()
            )?.commit()
    }
}