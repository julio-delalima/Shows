package com.coco.shows.domain.model

data class Show(
    val id:Int,
    val name: String?,
    val network: String?,
    val airDate: String?,
    val airTime: String?,
    val image: String?,
    val schedule: Schedule?,
    val rating: Float?,
    val site: String?,
    val summary: String?,
    val genres: List<String>?
)
// TODO: add Persons