package com.coco.shows.di

import com.coco.shows.domain.data.repository.ShowRepository
import com.coco.shows.domain.usecase.GetShowById
import com.coco.shows.domain.usecase.GetShows
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UsesCasesModule {

    @Provides
    @Singleton
    fun getShowsProvider(repository: ShowRepository): GetShows {
        return GetShows(repository)
    }

    @Provides
    @Singleton
    fun getShowByIdProvider(repository: ShowRepository): GetShowById {
        return GetShowById(repository)
    }
}