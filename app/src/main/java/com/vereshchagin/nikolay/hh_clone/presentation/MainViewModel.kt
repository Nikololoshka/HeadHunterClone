package com.vereshchagin.nikolay.hh_clone.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.vereshchagin.nikolay.hh_clone.domain.usecase.GetFavoriteVacanciesCountUseCase
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel @AssistedInject constructor(
    private val useCase: GetFavoriteVacanciesCountUseCase
) : ViewModel() {

    private val _favoriteCount = MutableStateFlow(0)
    val favoriteCount = _favoriteCount.asStateFlow()

    init {
        viewModelScope.launch {
            useCase().collect { count ->
                _favoriteCount.value = count
            }
        }
    }

    @AssistedFactory
    interface MainViewModelFactory {
        fun create(): MainViewModel
    }

    companion object {
        fun provideFactory(
            factory: MainViewModelFactory
        ) = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return factory.create() as T
            }
        }
    }
}