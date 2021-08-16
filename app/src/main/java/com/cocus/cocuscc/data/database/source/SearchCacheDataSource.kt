package com.cocus.cocuscc.data.database.source

import com.cocus.cocuscc.data.search.model.SearchResponse
import kotlinx.coroutines.flow.Flow

interface SearchCacheDataSource {

    //Retrieve data
    fun getSearchResult(): Flow<List<SearchResponse>>

    suspend fun cacheUpdate(result: SearchResponse): Flow<Boolean>
}