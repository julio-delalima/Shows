package com.coco.shows.domain.data.repository

import com.coco.shows.domain.data.source.ShowDataSource
import com.coco.shows.domain.model.Show
import io.reactivex.rxjava3.core.Single

class ShowRepository(private val dataSource: ShowDataSource) {
    fun getShows(date: String): Single<List<Show>> {
        // Determinar desde donde
        return dataSource.getShows(date)
    }

    fun getShow(id: Int) = dataSource.getShow(id)
}