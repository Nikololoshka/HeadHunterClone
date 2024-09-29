package com.vereshchagin.nikolay.favorite_impl.presentation

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.vereshchagin.nikolay.core_ui.presentation.fragment.BaseFragment
import com.vereshchagin.nikolay.core_ui.presentation.list.MarginItemDecorator
import com.vereshchagin.nikolay.core_ui.presentation.list.VacanciesListAdapter
import com.vereshchagin.nikolay.core_ui.presentation.utils.getPluralsString
import com.vereshchagin.nikolay.favorite_impl.R
import com.vereshchagin.nikolay.favorite_impl.databinding.FragmentFavoriteBinding
import com.vereshchagin.nikolay.favorite_impl.di.FavoriteComponent
import com.vereshchagin.nikolay.module_injector.appDependenciesProvider
import com.vereshchagin.nikolay.module_injector.scopedComponent
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class FavoriteFragment : BaseFragment<FragmentFavoriteBinding>(
    FragmentFavoriteBinding::inflate
) {

    @Inject
    lateinit var viewModelFactory: FavoriteViewModel.FavoriteViewModelFactory
    private val viewModel by viewModels<FavoriteViewModel> {
        FavoriteViewModel.provideFactory(viewModelFactory)
    }

    private lateinit var favoritesAdapter: VacanciesListAdapter

    private val favoriteComponent by scopedComponent {
        FavoriteComponent.create(appDependenciesProvider())
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        favoriteComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupVacanciesList()

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collectLatest(::onStateChanged)
            }
        }
    }

    private fun setupVacanciesList() {
        favoritesAdapter = VacanciesListAdapter()
        binding.favorites.adapter = favoritesAdapter

        val paddingBottom = resources.getDimensionPixelSize(com.vereshchagin.nikolay.core_ui.R.dimen.default_screen_margin)
        binding.favorites.addItemDecoration(MarginItemDecorator(bottom = paddingBottom * 2))
    }

    private fun onStateChanged(state: FavariteState) {
        val favoritesCount =  state.favorites.size
        binding.favoriteCounter.text = getPluralsString(R.plurals.favorite_counter,favoritesCount)

        favoritesAdapter.items = state.favorites
    }
}