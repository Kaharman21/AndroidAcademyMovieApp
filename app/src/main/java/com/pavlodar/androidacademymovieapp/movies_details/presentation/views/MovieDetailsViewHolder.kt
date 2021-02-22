package com.pavlodar.androidacademymovieapp.movies_details.presentation.views

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pavlodar.androidacademymovieapp.R
import com.pavlodar.androidacademymovieapp.movies_details.data.models.api.ActorOneApi
import com.pavlodar.androidacademymovieapp.movies_details.data.models.api.ActorsListApi
import com.pavlodar.androidacademymovieapp.movies_list.presentatin.views.ADDRESS_FOR_IMAGE

class MovieDetailsViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    private val actorPoster: ImageView = view.findViewById(R.id.view_holder_actor_photo)
    private val actorName: TextView = view.findViewById(R.id.view_holder_actor_name)

    fun onBind(actor: ActorOneApi) {
//        actorPoster.load(actor.imageUrl) {
//            placeholder(R.mipmap.ic_launcher)
//        }

        Glide.with(view.context)
            .load(ADDRESS_FOR_IMAGE + actor.profilePath)
            .placeholder(R.mipmap.ic_launcher)
            .into(actorPoster)

        actorName.text = actor.name
    }
}