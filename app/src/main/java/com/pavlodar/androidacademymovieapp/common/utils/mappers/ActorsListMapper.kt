package com.pavlodar.androidacademymovieapp.common.utils.mappers

import com.pavlodar.androidacademymovieapp.movies_details.data.models.api.Actor
import com.pavlodar.androidacademymovieapp.movies_details.data.models.api.ActorApi
import com.pavlodar.androidacademymovieapp.movies_details.data.models.db.ActorEntity

private const val DEFAULT_ACTOR_ID = 0L
private const val DEFAULT_ACTOR_NAME = ""
private const val DEFAULT_ACTOR_PROFILE_PATH = ""

class ActorsListMapper {

    fun mapFromApiToActorsList(actorsListApi: List<ActorApi>?) : List<Actor>{
        actorsListApi ?: emptyList()

        return actorsListApi!!.map {
            Actor(
                movieId = it.movieId ?: DEFAULT_ACTOR_ID,
                name = it.name ?: DEFAULT_ACTOR_NAME,
                profilePath = it.profilePath ?: DEFAULT_ACTOR_PROFILE_PATH
            )
        }
    }

    fun mapFromActorsListToApi(actorsList: List<Actor>?): List<ActorApi>{
        actorsList ?: emptyList()

        return actorsList!!.map {
            ActorApi(
                movieId = it.movieId,
                name = it.name,
                profilePath = it.profilePath
            )
        }
    }

    fun mapFromActorsListToEntity(actorsList: List<Actor>?) : List<ActorEntity>{
        actorsList ?: emptyList()

        return actorsList!!.map {
            ActorEntity(
                movieId = it.movieId,
                name = it.name,
                profilePath = it.profilePath
            )
        }
    }

    fun mapFromEntityToActorsList(actorsListEntity: List<ActorEntity>?) : List<Actor>{
        actorsListEntity ?: emptyList()

        return actorsListEntity!!.map {
            Actor(
                movieId = it.movieId ?: DEFAULT_ACTOR_ID,
                name = it.name ?: DEFAULT_ACTOR_NAME,
                profilePath = it.profilePath ?: DEFAULT_ACTOR_PROFILE_PATH
            )
        }
    }
}