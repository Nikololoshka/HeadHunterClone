package com.vereshchagin.nikolay.hh_clone.search_impl.di

import com.vereshchagin.nikolay.hh_clone.search_impl.presentation.home.SearchFragment
import com.vereshchagin.nikolay.hh_clone.module_injector.AppDependenciesProvider
import com.vereshchagin.nikolay.hh_clone.search_impl.di.DaggerSearchComponent
import com.vereshchagin.nikolay.hh_clone.search_impl.presentation.vacancies.SearchVacanciesFragment
import dagger.Component

@Component(
    dependencies = [
        AppDependenciesProvider::class
    ]
)
interface SearchComponent {

    fun inject(fragment: SearchFragment)
    fun inject(fragment: SearchVacanciesFragment)

    @Component.Factory
    interface Factory {
        fun create(
            appDependenciesProvider: AppDependenciesProvider
        ): SearchComponent
    }

    companion object {
        fun create(
            appDependenciesProvider: AppDependenciesProvider
        ): SearchComponent {
            return DaggerSearchComponent.factory()
                .create(appDependenciesProvider)
        }
    }
}