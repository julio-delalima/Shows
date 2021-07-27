package com.coco.shows.framework.data.local

import androidx.room.*
import com.coco.shows.framework.data.local.model.LShow

@Database(entities = [LShow::class], version = 1)
@TypeConverters(Converters::class)
abstract class ShowDatabase : RoomDatabase() {

    companion object {
        const val DB_NAME = "show-db"
    }

    abstract fun showDAO(): ShowDAO
}