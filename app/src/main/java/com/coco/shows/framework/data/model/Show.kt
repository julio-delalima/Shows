package com.coco.shows.framework.data.model

data class Show(
    val genres: List<String>,
    val id: Int,
    val image: Image,
    val name: String,
    val network: Network,
    val officialSite: String,
    val rating: Rating,
    val schedule: Schedule,
    val summary: String,
)