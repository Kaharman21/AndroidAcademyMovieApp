package com.pavlodar.androidacademymovieapp.common.utils.mappers

import com.pavlodar.androidacademymovieapp.movies_details.data.models.api.Actor
import com.pavlodar.androidacademymovieapp.movies_details.data.models.api.ActorApi

private const val DEFAULT_ACTOR_ID = 0L
private const val DEFAULT_ACTOR_NAME = ""
private const val DEFAULT_ACTOR_PROFILE_PATH = ""

class ActorsListMapper {

    fun mapToActorsList(actorsListApi: List<ActorApi>?) : List<Actor>{
        actorsListApi ?: emptyList()

        return actorsListApi!!.map {
            Actor(
                movieId = it.movieId ?: DEFAULT_ACTOR_ID,
                name = it.name ?: DEFAULT_ACTOR_NAME,
                profilePath = it.profilePath ?: DEFAULT_ACTOR_PROFILE_PATH
            )
        }
    }

    fun mapToActorsApiList(actorsList: List<Actor>?): List<ActorApi>{
        actorsList ?: emptyList()

        return actorsList!!.map {
            ActorApi(
                movieId = it.movieId,
                name = it.name,
                profilePath = it.profilePath
            )
        }
    }
}