package com.cocus.cocuscc.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class
    ]
)
interface SearchUserComponent {

    val viewModelComponent: ViewModelComponent

}