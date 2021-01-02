package com.pavlodar.androidacademymovieapp.movies_details.presentation.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pavlodar.androidacademymovieapp.R
import com.pavlodar.androidacademymovieapp.movies_list.data.model.Actor
import com.pavlodar.androidacademymovieapp.movies_list.presentatin.view.MoviesListViewHolder

class MoviesDetailsAdapter: RecyclerView.Adapter<MoviesDetailsViewHolder>() {

    private val actorList: MutableList<Actor> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesDetailsViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        return MoviesDetailsViewHolder(inflater.inflate(R.layout.view_holder_actor, parent, false))
    }

    override fun onBindViewHolder(holder: MoviesDetailsViewHolder, position: Int) {
        holder.onBind(actorList[position])
    }

    override fun getItemCount(): Int = actorList.size

    fun setData(actorData: List<Actor>){
        actorList.clear()
        actorList.addAll(actorData)
        notifyDataSetChanged()
    }
}