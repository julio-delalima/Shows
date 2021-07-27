package com.coco.shows.framework.data

import com.coco.shows.domain.model.Schedule
import com.coco.shows.domain.model.Show
import com.coco.shows.framework.data.model.Program

fun Program.toDomainShow() = Show(
    this.show.id,
    this.show.name,
    this.show.network.name,
    this.airdate,
    this.airtime,
    this.show.image.medium,
    Schedule(this.show.schedule.days, this.show.schedule.time),
    this.show.rating.average,
    this.show.officialSite,
    this.summary,
    this.show.genres
)

