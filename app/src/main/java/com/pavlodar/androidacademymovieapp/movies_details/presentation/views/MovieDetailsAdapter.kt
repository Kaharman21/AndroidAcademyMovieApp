package com.pavlodar.androidacademymovieapp.movies_details.presentation.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pavlodar.androidacademymovieapp.R

//class MovieDetailsAdapter: RecyclerView.Adapter<MovieDetailsViewHolder>() {
//
//    private val actorList: MutableList<ActorApi> = mutableListOf()
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieDetailsViewHolder {
//        var inflater = LayoutInflater.from(parent.context)
//        return MovieDetailsViewHolder(inflater.inflate(R.layout.view_holder_actor, parent, false))
//    }
//
//    override fun onBindViewHolder(holder: MovieDetailsViewHolder, position: Int) {
//        holder.onBind(actorList[position])
//    }
//
//    override fun getItemCount(): Int = actorList.size
//
//    fun setData(actorData: List<ActorApi>){
//        actorList.clear()
//        actorList.addAll(actorData)
//        notifyDataSetChanged()
//    }
//}