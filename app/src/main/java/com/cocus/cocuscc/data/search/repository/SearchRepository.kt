package com.cocus.cocuscc.data.search.repository

import com.cocus.cocuscc.data.search.model.SearchResponse
import kotlinx.coroutines.flow.Flow

interface SearchRepository {

    fun searchUser(username: String): Flow<SearchResponse>
    //fun retrieveCache(): Flow<Users>
}