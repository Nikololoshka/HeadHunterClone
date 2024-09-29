package com.vereshchagin.nikolay.favorite_impl.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.vereshchagin.nikolay.favorite_impl.domain.interceptor.FavoriteInterceptor
import com.vereshchagin.nikolay.favorite_impl.domain.usecase.GetFavoriteVacanciesUseCase
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FavoriteViewModel @AssistedInject constructor(
    private val interceptor: FavoriteInterceptor
): ViewModel() {

    private val _state = MutableStateFlow(FavariteState(emptyList()))
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            interceptor.favoriteVacancies().collect { favorites ->
                _state.update { s -> s.copy(favorites = favorites) }
            }
        }
    }

    fun removeFavoriteVacancy(id: String) {
        viewModelScope.launch {
            interceptor.setFavoriteVacancy(id)
        }
    }

    @AssistedFactory
    interface FavoriteViewModelFactory {
        fun create(): FavoriteViewModel
    }

    companion object {
        fun provideFactory(
            factory: FavoriteViewModelFactory
        ) = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return factory.create() as T
            }
        }
    }
}