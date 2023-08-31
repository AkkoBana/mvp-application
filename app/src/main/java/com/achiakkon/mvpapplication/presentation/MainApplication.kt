package com.achiakkon.mvpapplication.presentation

import android.app.Application
import com.achiakkon.mvpapplication.data.di.AppComponent
import com.achiakkon.mvpapplication.data.di.DaggerAppComponent

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().application(this).build()

    }

    companion object {
        lateinit var appComponent: AppComponent
    }
}