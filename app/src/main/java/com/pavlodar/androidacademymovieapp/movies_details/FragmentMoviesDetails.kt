package com.pavlodar.androidacademymovieapp.movies_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pavlodar.androidacademymovieapp.R
import com.pavlodar.androidacademymovieapp.common.presentation.view.BaseFragment
import com.pavlodar.androidacademymovieapp.movies_details.presentation.view.MoviesDetailsAdapter
import com.pavlodar.androidacademymovieapp.movies_list.data.model.Actor

class FragmentMoviesDetails: BaseFragment(R.layout.fragment_movies_details) {

    private lateinit var recyclerView: RecyclerView

    private var adapter: MoviesDetailsAdapter = MoviesDetailsAdapter()
    private var actorList: List<Actor> = listOf()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.fragment_movies_details_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
    }
}