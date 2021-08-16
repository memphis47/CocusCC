package com.cocus.cocuscc

import android.app.Application
import com.cocus.cocuscc.di.*

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
            .appModule(AppModule(this))
            .roomModule(RoomModule(this))
            .networkModule(NetworkModule()).build()
        return searchUserComponent
    }
}
