package com.pavlodar.androidacademymovieapp.movies_details.presentation.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.pavlodar.androidacademymovieapp.R
import com.pavlodar.androidacademymovieapp.movies_list.data.model.Actor

class MoviesDetailsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val actorPoster: ImageView = view.findViewById(R.id.view_holder_actor_photo)
    private val actorName: TextView = view.findViewById(R.id.view_holder_actor_name)

    fun onBind(actor: Actor) {
//        actorPoster.load(actor.picture) {
//            placeholder(R.mipmap.ic_launcher)
//        }
        actorPoster.load(R.drawable.chris_evans) {
            placeholder(R.mipmap.ic_launcher)
        }
        actorName.text = actor.name
    }
}