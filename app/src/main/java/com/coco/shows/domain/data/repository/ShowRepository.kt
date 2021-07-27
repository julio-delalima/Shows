package com.coco.shows.domain.data.repository

import com.coco.shows.domain.data.source.LocalDataSource
import com.coco.shows.domain.data.source.RemoteDataSource
import com.coco.shows.domain.model.Show
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class ShowRepository(
    private val remote: RemoteDataSource,
    private val local: LocalDataSource,
) {
    fun getShows(date: String): Single<List<Show>> {
        // Determinar desde donde
        //return remote.getShows(date)
        return if (local.isEmpty()) {
            val shows = remote.getShows(date)
            shows.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        local.saveShows(it)
                    },
                    {

                    }
                )
            //local.saveShows(shows.blockingGet())
            shows
        } else local.getShows(date)
    }

    fun getShow(id: Int) = local.getShow(id)
}