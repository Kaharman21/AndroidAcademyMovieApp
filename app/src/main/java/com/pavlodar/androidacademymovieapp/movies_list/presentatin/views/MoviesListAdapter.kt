package com.pavlodar.androidacademymovieapp.movies_list.presentatin.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pavlodar.androidacademymovieapp.R
import com.pavlodar.androidacademymovieapp.movies_list.data.models.MovieApiData
import com.pavlodar.androidacademymovieapp.movies_list.data.models.MovieData

class MoviesListAdapter(
    var clickListener: OnMovieClickListener
) : RecyclerView.Adapter<MoviesListViewHolder>() {

    private val moviesList: MutableList<MovieData> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesListViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        return MoviesListViewHolder(
            view = inflater.inflate(R.layout.view_holder_movie, parent, false),
            action = clickListener,
            context = parent.context
        )
    }

    override fun onBindViewHolder(holder: MoviesListViewHolder, position: Int) {
        holder.onBind(moviesList[position])
    }

    override fun getItemCount(): Int = moviesList.size

    fun setData(movieDatumData: List<MovieData>){
        moviesList.clear()
        moviesList.addAll(movieDatumData)
        notifyDataSetChanged()
    }
}