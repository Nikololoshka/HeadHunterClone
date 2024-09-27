package com.vereshchagin.nikolay.home_impl.presentation

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.vereshchagin.nikolay.core_ui.presentation.BaseFragment
import com.vereshchagin.nikolay.home_impl.databinding.FragmentHomeBinding
import com.vereshchagin.nikolay.home_impl.di.HomeComponent
import com.vereshchagin.nikolay.module_injector.appDependenciesProvider
import com.vereshchagin.nikolay.module_injector.scopedComponent
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeFragment : BaseFragment<FragmentHomeBinding>(
    FragmentHomeBinding::inflate
) {

    @Inject
    lateinit var viewModelFactory: HomeViewModel.HomeViewModelFactory
    private val viewModel by viewModels<HomeViewModel> {
        HomeViewModel.provideFactory(viewModelFactory)
    }

    private val homeComponent by scopedComponent {
        HomeComponent.create(appDependenciesProvider())
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        homeComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            viewModel.state.collectLatest { state ->
                Log.d("HomeFragment", "onViewCreated: $state")
            }
        }
    }
}