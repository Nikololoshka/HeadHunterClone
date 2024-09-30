package com.vereshchagin.nikolay.hh_clone.core_impl.di

import android.content.Context
import com.vereshchagin.nikolay.hh_clone.core_impl.di.DaggerCoreComponent
import com.vereshchagin.nikolay.hh_clone.core_impl.data.di.CoreDatabaseModule
import com.vereshchagin.nikolay.hh_clone.core_impl.data.di.CoreModule
import com.vereshchagin.nikolay.hh_clone.core_impl.data.di.CoreNetworkModule
import com.vereshchagin.nikolay.hh_clone.core_api.di.CoreProvider
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        CoreModule::class,
        CoreDatabaseModule::class,
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
            return DaggerCoreComponent.factory()
                .create(context)
        }
    }
}