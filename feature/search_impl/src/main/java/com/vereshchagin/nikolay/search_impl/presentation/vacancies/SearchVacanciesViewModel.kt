package com.vereshchagin.nikolay.search_impl.presentation.vacancies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.vereshchagin.nikolay.search_impl.domain.usecase.GetSearchVacanciesUseCase
import com.vereshchagin.nikolay.search_impl.presentation.home.SearchViewModel
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SearchVacanciesViewModel @AssistedInject constructor(
    private val useCase: GetSearchVacanciesUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(SearchVacanciesState(emptyList()))
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            val vacancies = useCase()
            _state.update { s -> s.copy(vacancies = vacancies) }
        }
    }

    @AssistedFactory
    interface SearchVacanciesViewModelFactory {
        fun create(): SearchVacanciesViewModel
    }

    companion object {
        fun provideFactory(
            factory: SearchVacanciesViewModelFactory
        ) = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return factory.create() as T
            }
        }
    }
}