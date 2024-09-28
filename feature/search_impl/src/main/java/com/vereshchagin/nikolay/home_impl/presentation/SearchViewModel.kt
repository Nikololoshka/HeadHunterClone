package com.vereshchagin.nikolay.home_impl.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.vereshchagin.nikolay.home_impl.domain.model.SearchHomeData
import com.vereshchagin.nikolay.home_impl.domain.usecase.GetSearchHomeDataUseCase
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SearchViewModel @AssistedInject constructor(
    private val useCase: GetSearchHomeDataUseCase
) : ViewModel() {


    private val _state = MutableStateFlow(
        SearchState(
            SearchHomeData(
                recommendations = emptyList(),
                vacancies = emptyList(),
                moreVacancies = 0
            )
        )
    )
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            val data = useCase()
            _state.update { s -> s.copy(data = data) }
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