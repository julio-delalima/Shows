package com.coco.shows.framework.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.coco.shows.framework.data.local.Converters
import java.io.Serializable

@Entity
data class LShow(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String?,
    val network: String?,
    val airDate: String?,
    val airTime: String?,
    val image: String?,
    val schedule: LSchedule?,
    val rating: Float?,
    val site: String?,
    val summary: String?,
    @TypeConverters(Converters::class) val genres: ArrayList<String>?,
) : Serializable