package com.vereshchagin.nikolay.hh_clone.di

import android.content.Context
import com.vereshchagin.nikolay.hh_clone.core_impl.di.CoreComponent
import com.vereshchagin.nikolay.hh_clone.core_api.di.CoreProvider
import com.vereshchagin.nikolay.hh_clone.presentation.MainActivity
import com.vereshchagin.nikolay.hh_clone.module_injector.AppDependenciesProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [
        CoreProvider::class
    ]
)
interface AppComponent : AppDependenciesProvider {

    fun inject(activity: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(
            coreProvider: CoreProvider
        ): AppComponent
    }

    companion object {

        fun create(context: Context): AppComponent {
            val coreProvider = CoreComponent.create(context)

            return DaggerAppComponent
                .factory()
                .create(coreProvider)
        }
    }
}