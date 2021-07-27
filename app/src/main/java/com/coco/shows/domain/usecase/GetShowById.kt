package com.coco.shows.domain.usecase

import com.coco.shows.domain.data.repository.ShowRepository
import com.coco.shows.domain.model.Show
import io.reactivex.rxjava3.core.Single

class GetShowById(private val repository: ShowRepository) {
    fun invoke(id: Int): Single<Show> {
        return repository.getShow(id)
    }
}