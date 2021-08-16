package com.cocus.cocuscc.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cocus.cocuscc.data.database.dao.SearchDao
import com.cocus.cocuscc.data.database.model.SearchCache

@Database(version = 1, entities = [SearchCache::class])
abstract class SearchCacheDatabase : RoomDatabase(){

    abstract fun searchDao(): SearchDao

    companion object {
        fun createDataBase(context: Context): SearchDao {
            return Room
                .databaseBuilder(context, SearchCacheDatabase::class.java, ".db")
                .build()
                .searchDao()
        }
    }
}