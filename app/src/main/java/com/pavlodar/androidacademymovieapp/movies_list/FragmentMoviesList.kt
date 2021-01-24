package com.pavlodar.androidacademymovieapp.movies_list

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pavlodar.androidacademymovieapp.R
import com.pavlodar.androidacademymovieapp.common.presentation.views.BaseFragment
import com.pavlodar.androidacademymovieapp.data.loadMovies
import com.pavlodar.androidacademymovieapp.movies_details.FragmentMoviesDetails
import com.pavlodar.androidacademymovieapp.movies_list.data.models.Actor
import com.pavlodar.androidacademymovieapp.movies_list.data.models.Genre
import com.pavlodar.androidacademymovieapp.movies_list.data.models.Movie
import com.pavlodar.androidacademymovieapp.movies_list.presentatin.views.MoviesListAdapter
import com.pavlodar.androidacademymovieapp.movies_list.presentatin.views.OnItemClickListener
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class FragmentMoviesList(private val mainActivityContext: Context) :
    BaseFragment(R.layout.fragment_movies_list),
    OnItemClickListener,
    CoroutineScope{

//   private val coroutineScope = CoroutineScope(Dispatchers.Default + Job())

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job
    private lateinit var job: Job

    private lateinit var recyclerView: RecyclerView

    private var adapter = MoviesListAdapter(this, mainActivityContext)
    private var moviesData: List<Movie>? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        job = Job()

        recyclerView = view.findViewById(R.id.fragment_movies_list_recycler_view)
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        recyclerView.adapter = adapter

        loadData()
    }

    override fun onMovieItemClick(movieId: Int, movie: Movie) {
        goToFragmentMoviesDetails(movieId, movie)
    }

    private fun loadData() {
        launch {
            moviesData = loadMovies(mainActivityContext)
            adapter.setData(moviesData ?: moviesMockData())
        }
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