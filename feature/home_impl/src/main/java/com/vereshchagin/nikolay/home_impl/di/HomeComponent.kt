package com.vereshchagin.nikolay.home_impl.di

import com.vereshchagin.nikolay.home_impl.presentation.HomeFragment
import com.vereshchagin.nikolay.module_injector.AppDependenciesProvider
import dagger.Component

@Component(
    dependencies = [
        AppDependenciesProvider::class
    ]
)
interface HomeComponent {

    fun inject(fragment: HomeFragment)

    @Component.Factory
    interface Factory {
        fun create(
            appDependenciesProvider: AppDependenciesProvider
        ): HomeComponent
    }

    companion object {
        fun create(
            appDependenciesProvider: AppDependenciesProvider
        ): HomeComponent {
            return DaggerHomeComponent
                .factory()
                .create(appDependenciesProvider)
        }
    }
}