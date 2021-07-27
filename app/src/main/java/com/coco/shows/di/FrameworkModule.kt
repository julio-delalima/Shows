package com.coco.shows.di

import android.app.Application
import androidx.room.Room
import com.coco.shows.domain.data.source.LocalDataSource
import com.coco.shows.domain.data.source.RemoteDataSource
import com.coco.shows.framework.data.local.RoomDataSource
import com.coco.shows.framework.data.local.ShowDAO
import com.coco.shows.framework.data.local.ShowDatabase
import com.coco.shows.framework.data.server.ApiService
import com.coco.shows.framework.data.server.RetrofitDataSource
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
    fun showDataSourceProvider(apiService: ApiService): RemoteDataSource {
        return RetrofitDataSource(apiService)
    }

    @Provides
    @Singleton
    fun localDataSourceProvider(database: ShowDatabase): LocalDataSource {
        return RoomDataSource(database)
    }

    @Provides
    @Singleton
    fun localDatabaseProvider(application: Application): ShowDatabase {
        return Room.databaseBuilder(
            application,
            ShowDatabase::class.java,
            ShowDatabase.DB_NAME
        ).allowMainThreadQueries().build()
    }



    @Provides
    @Singleton
    internal fun providePhotoDao(database: ShowDatabase): ShowDAO {
        return database.showDAO()
    }
}