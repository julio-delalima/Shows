package com.coco.shows.di

import com.coco.shows.domain.data.source.ShowDataSource
import com.coco.shows.framework.data.server.ApiService
import com.coco.shows.framework.data.server.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FrameworkModule {

    @Provides
    @Singleton
    fun showDataSourceProvider(apiService: ApiService): ShowDataSource {
        return RemoteDataSource(apiService)
    }
}