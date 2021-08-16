package com.cocus.cocuscc.data.database.source

import com.cocus.cocuscc.data.database.dao.SearchDao
import com.cocus.cocuscc.data.database.mapper.ResultMapper
import com.cocus.cocuscc.data.search.model.SearchResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchCacheDataSourceImpl @Inject constructor(val searchDao: SearchDao) :
    SearchCacheDataSource {

    override fun getSearchResult(): Flow<List<SearchResponse>> = flow {
        searchDao.getResult().collect { cache ->
            emit(ResultMapper.mapCacheToResult(cache))
        }
    }

    override suspend fun cacheUpdate(result: SearchResponse): Flow<Boolean> = flow {
        searchDao.updateResult(ResultMapper.mapsResultToCache(result)).collect {
            emit(it)
        }
    }
}