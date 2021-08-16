package com.cocus.cocuscc.domain.interactor

import com.cocus.cocuscc.data.search.model.SearchResponse
import com.cocus.cocuscc.data.search.repository.SearchRepository
import kotlinx.coroutines.flow.Flow

class UpdateCache(private val repository: SearchRepository) :
    UseCase<Boolean, SearchResponse>() {

    override fun run(params: SearchResponse): Flow<Boolean> {
        return repository.updateCache(params)
    }
}