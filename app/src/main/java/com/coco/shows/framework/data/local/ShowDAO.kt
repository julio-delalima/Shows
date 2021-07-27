package com.coco.shows.framework.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.coco.shows.framework.data.local.model.LShow
import io.reactivex.rxjava3.core.Single

@Dao
interface ShowDAO {
    @Query("SELECT * FROM LShow where airDate = :date")
    fun getShows(date: String): Single<List<LShow>>

    @Query("SELECT * FROM LShow WHERE id = :id")
    fun getShow(id: Int): Single<LShow>

    @Query("SELECT COUNT(id) FROM LShow")
    fun showsCount(): Int

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun saveShows(movies: List<LShow>)

}