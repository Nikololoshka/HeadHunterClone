package com.vereshchagin.nikolay.search_impl.presentation.home

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.net.toUri
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.fragment.findNavController
import com.vereshchagin.nikolay.core_ui.presentation.BaseFragment
import com.vereshchagin.nikolay.core_ui.presentation.MarginItemDecorator
import com.vereshchagin.nikolay.core_ui.presentation.getPluralsString
import com.vereshchagin.nikolay.core_ui.presentation.visible
import com.vereshchagin.nikolay.search_impl.R
import com.vereshchagin.nikolay.search_impl.databinding.FragmentSearchBinding
import com.vereshchagin.nikolay.search_impl.di.SearchComponent
import com.vereshchagin.nikolay.search_impl.presentation.list.RecommendationListAdapter
import com.vereshchagin.nikolay.search_impl.presentation.list.VacanciesListAdapter
import com.vereshchagin.nikolay.module_injector.appDependenciesProvider
import com.vereshchagin.nikolay.module_injector.scopedComponent
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.vereshchagin.nikolay.core_ui.R as R_core_ui

class SearchFragment : BaseFragment<FragmentSearchBinding>(
    FragmentSearchBinding::inflate
) {

    @Inject
    lateinit var viewModelFactory: SearchViewModel.HomeViewModelFactory
    private val viewModel by viewModels<SearchViewModel> {
        SearchViewModel.provideFactory(viewModelFactory)
    }

    private lateinit var recommendationAdapter: RecommendationListAdapter
    private lateinit var vacancyAdapter: VacanciesListAdapter


    private val searchComponent by scopedComponent {
        SearchComponent.create(appDependenciesProvider())
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        searchComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecommendationList()
        setupVacanciesList()
        binding.moreVacancies.setOnClickListener {
            val request = NavDeepLinkRequest.Builder
                .fromUri("android-app://com.vereshchagin.nikolay.hh_clone/search_vacancies_nav".toUri())
                .build()
            findNavController().navigate(request)
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collectLatest(::onStateUpdated)
            }
        }
    }

    private fun setupRecommendationList() {
        recommendationAdapter = RecommendationListAdapter()
        binding.recommendations.adapter = recommendationAdapter

        val paddingEnd = resources.getDimensionPixelSize(R_core_ui.dimen.default_screen_margin)
        binding.recommendations.addItemDecoration(MarginItemDecorator(end = paddingEnd))
    }

    private fun setupVacanciesList() {
        vacancyAdapter = VacanciesListAdapter()
        binding.vacancies.adapter = vacancyAdapter

        val paddingBottom = resources.getDimensionPixelSize(R_core_ui.dimen.default_screen_margin)
        binding.vacancies.addItemDecoration(MarginItemDecorator(bottom = paddingBottom * 2))
    }

    private fun onStateUpdated(state: SearchState) {
        recommendationAdapter.items = state.data.recommendations
        binding.recommendations.visible(visible = state.data.recommendations.isNotEmpty())

        vacancyAdapter.items = state.data.vacancies

        val vacanciesCount = state.data.moreVacancies
        binding.moreVacancies.text = getPluralsString(R.plurals.more_vacancies, vacanciesCount)
    }
}