package com.cocus.cocuscc.data.search.repository

import android.util.Log
import com.cocus.cocuscc.data.database.source.SearchCacheDataSource
import com.cocus.cocuscc.data.search.api.SearchService
import com.cocus.cocuscc.data.search.model.SearchResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val service: SearchService,
    private val cacheDataSource: SearchCacheDataSource
) : SearchRepository {

    companion object {
        const val LOG_SEARCH = "SearchRepositoryImpl"
    }

    override fun searchUser(username: String): Flow<SearchResponse> = flow {
        try {
            val response = service.getUser(username)
            if (response.isSuccessful) {
                response.body()?.let { result ->
                    result.ranks.languages.map { languages ->
                        languages.value.language = languages.key
                    }
                    emit(SearchResponse(result, true))
                } ?: emit(SearchResponse(null, false))
            } else {
                emit(SearchResponse(null, false))
            }
        } catch (e: Exception) {
            Log.e(LOG_SEARCH, e.message, e)
            emit(SearchResponse(null, false))
        }
    }

    override fun retrieveCache(): Flow<List<SearchResponse>> = flow {
        cacheDataSource.getSearchResult().collect { cache ->
            emit(cache)
        }
    }

    override fun updateCache(searchResponse: SearchResponse) = flow {
        cacheDataSource.cacheUpdate(searchResponse).collect {
            emit(it)
        }
    }
}