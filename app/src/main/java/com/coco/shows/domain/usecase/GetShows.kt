package com.coco.shows.domain.usecase

import com.coco.shows.domain.data.repository.ShowRepository
import com.coco.shows.domain.model.Show
import io.reactivex.rxjava3.core.Single

class GetShows(private val repository: ShowRepository) {
    fun invoke(date: String): Single<List<Show>> = repository.getShows(date)
}