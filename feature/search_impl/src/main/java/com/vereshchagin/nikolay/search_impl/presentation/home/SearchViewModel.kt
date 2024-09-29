package com.vereshchagin.nikolay.search_impl.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.vereshchagin.nikolay.search_impl.domain.interceptor.SearchHomeDataInterceptor
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SearchViewModel @AssistedInject constructor(
    private val interceptor: SearchHomeDataInterceptor
) : ViewModel() {


    private val _state = MutableStateFlow(
        SearchState(
            recommendations = emptyList(),
            vacancies = emptyList(),
            moreVacancies = 0
        )
    )
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            interceptor.relativeVacancies().collectLatest { vacancies ->
                _state.update { s -> s.copy(vacancies = vacancies) }
            }
        }

        viewModelScope.launch {
            interceptor.recommendations().collectLatest { recommendations ->
                _state.update { s -> s.copy(recommendations = recommendations) }
            }
        }

        viewModelScope.launch {
            interceptor.moreVacanciesCount().collectLatest { count ->
                _state.update { s -> s.copy(moreVacancies = count) }
            }
        }
    }

    fun setFavoriteVacancy(id: String) {
        viewModelScope.launch {
            interceptor.setFavoriteVacancy(id)
        }
    }

    @AssistedFactory
    interface HomeViewModelFactory {
        fun create(): SearchViewModel
    }

    companion object {
        fun provideFactory(
            factory: HomeViewModelFactory
        ) = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return factory.create() as T
            }
        }
    }
}