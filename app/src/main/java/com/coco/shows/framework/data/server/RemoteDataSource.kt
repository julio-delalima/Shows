package com.coco.shows.framework.data.server

import com.coco.shows.domain.data.source.ShowDataSource
import com.coco.shows.domain.model.Show
import com.coco.shows.framework.data.toDomainShow
import io.reactivex.rxjava3.core.Single

class RemoteDataSource(private val apiService: ApiService) : ShowDataSource {
    override fun getShows(date: String): Single<List<Show>> {
        // Convert
        return apiService.getShows(date).map { list -> list.map { item -> item.toDomainShow() } }
    }

    override fun getShow(id: Int): Single<Show> {
        return apiService.getShow(id).map { it.toDomainShow() }
    }
}