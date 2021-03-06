package com.coco.shows.framework.data.server.model

data class Program(
    val id: Int,
    val airdate: String,
    val airtime: String,
    val name: String,
    val show: Show,
    val summary: String,
)