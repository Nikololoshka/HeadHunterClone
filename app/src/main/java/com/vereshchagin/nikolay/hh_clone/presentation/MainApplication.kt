package com.vereshchagin.nikolay.hh_clone.presentation

import android.app.Application
import com.vereshchagin.nikolay.hh_clone.di.AppComponent
import com.vereshchagin.nikolay.hh_clone.module_injector.App
import com.vereshchagin.nikolay.hh_clone.module_injector.AppDependenciesProvider

class MainApplication : Application(), App {

    val appComponent: AppComponent by lazy { AppComponent.create(this) }

    override fun onCreate() {
        super.onCreate()
        Instance = this
    }

    companion object {
        lateinit var Instance: MainApplication
    }

    override fun appDependenciesProvider(): AppDependenciesProvider {
        return appComponent
    }
}