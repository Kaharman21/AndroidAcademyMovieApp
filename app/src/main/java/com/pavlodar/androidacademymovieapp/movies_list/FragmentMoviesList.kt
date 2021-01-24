package com.pavlodar.androidacademymovieapp.movies_list

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pavlodar.androidacademymovieapp.MainActivity
import com.pavlodar.androidacademymovieapp.R
import com.pavlodar.androidacademymovieapp.common.presentation.views.BaseFragment
import com.pavlodar.androidacademymovieapp.movies_list.data.models.Movie
import com.pavlodar.androidacademymovieapp.movies_list.presentatin.view_model.MovieListViewModel
import com.pavlodar.androidacademymovieapp.movies_list.presentatin.views.MoviesListAdapter
import com.pavlodar.androidacademymovieapp.movies_list.presentatin.views.OnMovieClickListener
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class FragmentMoviesList() :
    BaseFragment(R.layout.fragment_movies_list),
//    CoroutineScope,
    LifecycleOwner {

//    override val coroutineContext: CoroutineContext
//        get() = Dispatchers.Main + job
//    private lateinit var job: Job

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MoviesListAdapter

    private var listener: OnMovieClickListener? = null
    private val viewModel: MovieListViewModel by viewModels()

    private var testMovieData: Movie? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        job = Job()

        recyclerView = view.findViewById(R.id.fragment_movies_list_recycler_view)
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        adapter = MoviesListAdapter(listener!!)
        recyclerView.adapter = adapter
//        recyclerView.run {
//            layoutManager = GridLayoutManager(context, 2)
//            adapter = listener?.let { MoviesListAdapter(it)}
//        }


        initViewModel()
    }

//    override fun onMovieItemClick(movie: Movie) {
//        goToFragmentMoviesDetails(movie)
//    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnMovieClickListener) {
            listener = context
        }
    }

    override fun onDetach() {
        listener = null
        super.onDetach()
    }

    private fun initViewModel() {
        viewModel.getMovieList().observe(this.viewLifecycleOwner, ::loadData)
  //      viewModel.getMovieList().observe(this.viewLifecycleOwner, ::testForMovieData)
    }

    private fun loadData(movieList: List<Movie>) {
        adapter.setData(movieList)
    }

//    private fun testForMovieData(movieList: List<Movie>){
//        adapter.setData(movieList)
//        testMovieData = movieList.get(0)
//    }

//    private fun goToFragmentMoviesDetails(movie: Movie) {
//
//        val newMovie = Movie (1, "", "" ,"", "", 1, 1, 1, 1, emptyList(), emptyList(), false)
//        fragmentManager?.beginTransaction()
//            ?.addToBackStack(null)
//            ?.replace(
//                R.id.main_activity_container,
//                FragmentMoviesDetails(1)
//            )?.commit()
//
//        MainActivity().goToDetailsFragment()
//    }
}