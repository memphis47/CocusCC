package com.cocus.cocuscc

import android.app.Application
import com.cocus.cocuscc.di.AppModule
import com.cocus.cocuscc.di.DaggerSearchUserComponent
import com.cocus.cocuscc.di.NetworkModule
import com.cocus.cocuscc.di.SearchUserComponent

class CocusCCApplication : Application() {

    companion object {
        lateinit var searchUserComponent: SearchUserComponent
    }

    override fun onCreate() {
        super.onCreate()
        searchUserComponent = initializeComponent()
    }

    fun getComponent(): SearchUserComponent {
        return searchUserComponent
    }

    fun initializeComponent(): SearchUserComponent {
        searchUserComponent = DaggerSearchUserComponent.builder()
            .appModule(AppModule(this)).networkModule(NetworkModule()).build()
        return searchUserComponent
    }
}
