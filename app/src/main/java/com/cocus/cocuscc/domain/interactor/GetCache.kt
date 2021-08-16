package com.cocus.cocuscc.domain.interactor

import com.cocus.cocuscc.data.search.model.SearchResponse
import com.cocus.cocuscc.data.search.repository.SearchRepository
import kotlinx.coroutines.flow.Flow

class GetCache(private val repository: SearchRepository) :
    UseCase<List<SearchResponse>, Unit>() {

    override fun run(params: Unit): Flow<List<SearchResponse>> {
        return repository.retrieveCache()
    }
}