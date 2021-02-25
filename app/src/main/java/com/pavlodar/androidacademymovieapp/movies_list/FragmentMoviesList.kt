package com.pavlodar.androidacademymovieapp.movies_list

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pavlodar.androidacademymovieapp.R
import com.pavlodar.androidacademymovieapp.common.extensions.showToast
import com.pavlodar.androidacademymovieapp.common.presentation.views.BaseFragment
import com.pavlodar.androidacademymovieapp.movies_list.data.models.MovieData
import com.pavlodar.androidacademymovieapp.movies_list.presentatin.view_model.MoviesListViewModel
import com.pavlodar.androidacademymovieapp.movies_list.presentatin.views.MoviesListAdapter
import com.pavlodar.androidacademymovieapp.movies_list.presentatin.views.OnMovieClickListener
import com.pavlodar.androidacademymovieapp.movies_list.utils.MoviesListResponseData

class FragmentMoviesList :
    BaseFragment(R.layout.fragment_movies_list),
    LifecycleOwner {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MoviesListAdapter

    private var listener: OnMovieClickListener? = null
    private val viewModel: MoviesListViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.fragment_movies_list_recycler_view)
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        adapter = MoviesListAdapter(listener!!)
        recyclerView.adapter = adapter

        initViewModel()
    }

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
        viewModel.loadData()
        viewModel.getMoviesList().observe(this.viewLifecycleOwner, ::loadData)
    }

    private fun loadData(moviesList: MoviesListResponseData<List<MovieData>, String>?) {
        when (moviesList){
            is MoviesListResponseData.Success -> adapter.setData(moviesList.response)
            is MoviesListResponseData.Erroe -> handleErrorResponse(moviesList.error)
        }
    }

    private fun handleErrorResponse(errorMessage: String){
        context?.showToast(errorMessage)
    }
}