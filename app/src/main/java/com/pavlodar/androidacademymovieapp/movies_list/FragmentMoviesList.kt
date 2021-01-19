package com.pavlodar.androidacademymovieapp.movies_list

import android.app.Application
import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pavlodar.androidacademymovieapp.R
import com.pavlodar.androidacademymovieapp.common.presentation.views.BaseFragment
import com.pavlodar.androidacademymovieapp.data.loadMovies
import com.pavlodar.androidacademymovieapp.movies_details.FragmentMoviesDetails
import com.pavlodar.androidacademymovieapp.movies_list.data.models.Actor
import com.pavlodar.androidacademymovieapp.movies_list.data.models.Genre
import com.pavlodar.androidacademymovieapp.movies_list.data.models.Movie
import com.pavlodar.androidacademymovieapp.movies_list.presentatin.view_model.MovieListViewModel
import com.pavlodar.androidacademymovieapp.movies_list.presentatin.views.MoviesListAdapter
import com.pavlodar.androidacademymovieapp.movies_list.presentatin.views.OnItemClickListener
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class FragmentMoviesList(private val mainActivityContext: Context) :
    BaseFragment(R.layout.fragment_movies_list),
    OnItemClickListener,
    CoroutineScope,
    LifecycleOwner {

//   private val coroutineScope = CoroutineScope(Dispatchers.Default + Job())

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job
    private lateinit var job: Job

    private lateinit var recyclerView: RecyclerView

    private var adapter = MoviesListAdapter(this, mainActivityContext)
    private var moviesData: List<Movie>? = null
    private val viewModel: MovieListViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        job = Job()

        recyclerView = view.findViewById(R.id.fragment_movies_list_recycler_view)
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        recyclerView.adapter = adapter

        initViewModel()
    }

    override fun onMovieItemClick(movieId: Int, movie: Movie) {
        goToFragmentMoviesDetails(movieId, movie)
    }

    private fun initViewModel() {
        viewModel.getMovieList().observe(this.viewLifecycleOwner, ::loadData)
    }

    private fun loadData(movieList: List<Movie>) {
        adapter.setData(movieList)
    }

    private fun moviesMockData(): List<Movie> {
        moviesData = listOf(
            Movie(
                0, "aaaa", "", "", "", 2,
                1, 1, 2, listOf(Genre(1, "2")),
                listOf(Actor(1, "", "")), false
            ),
            Movie(
                0, "aaaa", "", "", "", 2,
                1, 1, 2, listOf(Genre(1, "2")),
                listOf(Actor(1, "", "")), true
            ),
            Movie(
                0, "aaaa", "", "", "", 2,
                1, 1, 2, listOf(Genre(1, "2")),
                listOf(Actor(1, "", "")), false
            ),
            Movie(
                0, "aaaa", "", "", "", 2,
                1, 1, 2, listOf(Genre(1, "2")),
                listOf(Actor(1, "", "")), true
            )
        )
        return moviesData as List<Movie>
    }

    private fun goToFragmentMoviesDetails(movieId: Int, movie: Movie) {
        fragmentManager?.beginTransaction()
            ?.addToBackStack(null)
            ?.replace(
                R.id.main_activity_container,
                FragmentMoviesDetails(movieId, movie)
            )?.commit()
    }
}