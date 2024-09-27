package com.vereshchagin.nikolay.home_impl.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.vereshchagin.nikolay.home_impl.domain.usecase.GetHomeDataUseCase
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel @AssistedInject constructor(
    private val useCase: GetHomeDataUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(HomeState(null))
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            val newHomeData = useCase()
            _state.update { s -> s.copy(data = newHomeData) }
        }
    }

    @AssistedFactory
    interface HomeViewModelFactory {
        fun create(): HomeViewModel
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