package com.coco.shows.di

import com.coco.shows.domain.data.repository.ShowRepository
import com.coco.shows.domain.data.source.LocalDataSource
import com.coco.shows.domain.data.source.RemoteDataSource
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
    fun showRepositoryProvider(local: LocalDataSource, remote: RemoteDataSource): ShowRepository {
        return ShowRepository(remote, local)
    }
}