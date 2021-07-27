package com.coco.shows.di

import com.coco.shows.domain.data.repository.ShowRepository
import com.coco.shows.domain.data.source.ShowDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun showRepositoryProvider(dataSource:ShowDataSource): ShowRepository {
        return ShowRepository(dataSource)
    }
}