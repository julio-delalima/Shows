package com.coco.shows.framework.data.local

import androidx.room.TypeConverter
import com.coco.shows.framework.data.local.model.LSchedule
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class Converters {
    private val gson = Gson()

    @TypeConverter
    fun scheduleToString(schedule: LSchedule): String {
        return gson.toJson(schedule)
    }

    @TypeConverter
    fun stringToSchedule(scheduleString: String): LSchedule {
        val objectType = object : TypeToken<LSchedule>() {}.type
        return gson.fromJson(scheduleString, objectType)
    }

    @TypeConverter
    fun fromString(value: String?): ArrayList<String?>? {
        val listType: Type = object : TypeToken<ArrayList<String?>?>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayList(list: ArrayList<String?>?): String? {
        val gson = Gson()
        return gson.toJson(list)
    }
}