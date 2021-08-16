package com.cocus.cocuscc.domain.interactor

import com.cocus.cocuscc.data.search.model.SearchResponse
import com.cocus.cocuscc.data.search.repository.SearchRepository
import kotlinx.coroutines.flow.Flow

class GetUser(private val repository: SearchRepository) :
    UseCase<SearchResponse, String>() {

    override fun run(params: String): Flow<SearchResponse> {
        return repository.searchUser(params)
    }
}