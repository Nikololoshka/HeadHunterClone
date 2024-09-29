package com.vereshchagin.nikolay.favorite_impl.di

import com.vereshchagin.nikolay.favorite_impl.presentation.FavoriteFragment
import com.vereshchagin.nikolay.module_injector.AppDependenciesProvider
import dagger.Component

@Component(
    dependencies = [
        AppDependenciesProvider::class
    ]
)
interface FavoriteComponent {

    fun inject(fragment: FavoriteFragment)

    @Component.Factory
    interface Factory {
        fun create(
            appDependenciesProvider: AppDependenciesProvider
        ): FavoriteComponent
    }

    companion object {
        fun create(
            appDependenciesProvider: AppDependenciesProvider
        ): FavoriteComponent {
            return DaggerFavoriteComponent
                .factory()
                .create(appDependenciesProvider)
        }
    }
}