package com.coco.shows.domain.data.source

import com.coco.shows.domain.model.Show
import io.reactivex.rxjava3.core.Single

interface LocalDataSource {
    fun isEmpty(): Boolean
    fun saveShows(shows: List<Show>)
    fun getShows(date: String): Single<List<Show>>
    fun getShow(id: Int): Single<Show>
}