package com.coco.shows.framework.data.server

import com.coco.shows.domain.data.source.RemoteDataSource
import com.coco.shows.domain.model.Show
import com.coco.shows.framework.data.toDomainShow
import io.reactivex.rxjava3.core.Single

class RetrofitDataSource(private val apiService: ApiService) :
    RemoteDataSource {
    override fun getShows(date: String): Single<List<Show>> {
        // Convert
        return apiService.getShows(date).map { list -> list.map { item -> item.toDomainShow() } }
    }

    override fun getShow(id: Int): Single<Show> {
        return apiService.getShow(id).map { it.toDomainShow() }
    }
}