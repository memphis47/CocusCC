package com.cocus.cocuscc.di

import com.cocus.cocuscc.feature.search.view.fragment.viewModel.SearchViewModel
import dagger.Subcomponent

@Subcomponent(modules = [UseCaseModule::class])
interface ViewModelComponent {
    val searchViewModel: SearchViewModel
}