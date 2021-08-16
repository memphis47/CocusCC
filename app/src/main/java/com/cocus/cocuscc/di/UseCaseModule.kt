package com.cocus.cocuscc.di

import com.cocus.cocuscc.data.search.model.SearchResponse
import com.cocus.cocuscc.data.search.repository.SearchRepository
import com.cocus.cocuscc.data.search.repository.SearchRepositoryImpl
import com.cocus.cocuscc.domain.interactor.GetUser
import com.cocus.cocuscc.domain.interactor.UseCase
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface UseCaseModule {

    companion object {

        @Provides
        fun provideGetUser(repository: SearchRepository): UseCase<SearchResponse, String> {
            return GetUser(repository)
        }
    }

    @Binds
    fun bindSearchRepository(repository: SearchRepositoryImpl): SearchRepository
}