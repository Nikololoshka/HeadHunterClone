package com.vereshchagin.nikolay.core.di

import android.content.Context
import com.vereshchagin.nikolay.core.data.di.CoreModule
import com.vereshchagin.nikolay.core.data.di.CoreNetworkModule
import com.vereshchagin.nikolay.core_api.di.CoreProvider
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        CoreModule::class,
        CoreNetworkModule::class,
    ],
)
@Singleton
interface CoreComponent : CoreProvider {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): CoreComponent
    }

    companion object {

        fun create(context: Context): CoreComponent {
            return DaggerCoreComponent
                .factory()
                .create(context)
        }
    }
}