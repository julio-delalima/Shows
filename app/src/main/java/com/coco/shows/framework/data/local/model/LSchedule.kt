package com.coco.shows.framework.data.local.model

import java.io.Serializable

data class LSchedule(
    val days: List<String>,
    val time: String,
) : Serializable