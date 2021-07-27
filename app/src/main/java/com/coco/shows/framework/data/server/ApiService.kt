package com.coco.shows.framework.data.server

import com.coco.shows.framework.data.model.Program
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

// TODO: get out from here
interface ApiService {
    /**
     * Método que lista los shows por país y fecha
     */
    @GET("schedule")
    fun getShows(
        @Query("date") date: String,
        @Query("country") country: String? = null,
    ): Single<List<Program>>

    @GET("shows/{id}")
    fun getShow(
        @Path("id") id: Int,
    ): Single<Program>
}