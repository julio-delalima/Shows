package com.coco.shows.framework.data.local

import com.coco.shows.domain.data.source.LocalDataSource
import com.coco.shows.domain.model.Show
import com.coco.shows.framework.data.toDomainShow
import com.coco.shows.framework.data.toLocalShow
import io.reactivex.rxjava3.core.Single

class RoomDataSource(database: ShowDatabase) : LocalDataSource {
    private val dao = database.showDAO()

    override fun isEmpty(): Boolean = dao.showsCount() == 0

    override fun saveShows(shows: List<Show>) {
        dao.saveShows(shows.map {
            it.toLocalShow()
        })
    }

    override fun getShows(date: String): Single<List<Show>> {
        return dao.getShows(date).map { list -> list.map { item -> item.toDomainShow() } }
    }

    override fun getShow(id: Int): Single<Show> {
        return dao.getShow(id).map { item -> item.toDomainShow() }
    }
}