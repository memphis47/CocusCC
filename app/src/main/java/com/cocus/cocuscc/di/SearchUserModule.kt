package com.cocus.cocuscc.di

import com.cocus.cocuscc.data.search.repository.SearchRepository
import com.cocus.cocuscc.data.search.repository.SearchRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface SearchUserModule {

    @Binds
    fun bindSearchRepository(searchRepository: SearchRepositoryImpl): SearchRepository


}