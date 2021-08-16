package com.cocus.cocuscc.di

import android.content.Context
import com.cocus.cocuscc.data.database.SearchCacheDatabase
import com.cocus.cocuscc.data.database.dao.SearchDao
import com.cocus.cocuscc.data.database.source.SearchCacheDataSource
import com.cocus.cocuscc.data.database.source.SearchCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule(private val context: Context) {

    @Singleton
    @Provides
    fun providesSearchDao(): SearchDao {
        return SearchCacheDatabase.createDataBase(context)
    }

    @Singleton
    @Provides
    fun providesRepository(searchDao: SearchDao): SearchCacheDataSource {
        return SearchCacheDataSourceImpl(searchDao)
    }


}