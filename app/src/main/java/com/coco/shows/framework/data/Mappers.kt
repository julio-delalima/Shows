package com.coco.shows.framework.data

import com.coco.shows.domain.model.Schedule
import com.coco.shows.domain.model.Show
import com.coco.shows.framework.data.local.model.LSchedule
import com.coco.shows.framework.data.local.model.LShow
import com.coco.shows.framework.data.server.model.Program

fun Program.toDomainShow() = Show(
    this.show.id,
    this.show.name,
    this.show.network?.name,
    this.airdate,
    this.airtime,
    this.show.image.medium,
    Schedule(this.show.schedule.days, this.show.schedule.time),
    this.show.rating.average,
    this.show.officialSite,
    this.summary,
    this.show.genres
)

fun Show.toLocalShow() = LShow(
    this.id,
    this.name,
    this.network,
    this.airDate,
    this.airTime,
    this.image,
    this.schedule?.let { LSchedule(this.schedule.days, it.time) },
    this.rating,
    this.site,
    this.summary,
    this.genres as ArrayList<String>?
)

fun LShow.toDomainShow() = Show(
    this.id,
    this.name,
    this.network,
    this.airDate,
    this.airTime,
    this.image,
    this.schedule?.let { Schedule(this.schedule.days, it.time) },
    this.rating,
    this.site,
    this.summary,
    this.genres
)
