package com.vereshchagin.nikolay.home_impl.presentation

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.vereshchagin.nikolay.core_ui.R as R_core_ui
import com.vereshchagin.nikolay.core_ui.presentation.BaseFragment
import com.vereshchagin.nikolay.core_ui.presentation.MarginItemDecorator
import com.vereshchagin.nikolay.core_ui.presentation.WordDeclension
import com.vereshchagin.nikolay.core_ui.presentation.visible
import com.vereshchagin.nikolay.home_impl.R
import com.vereshchagin.nikolay.home_impl.databinding.FragmentHomeBinding
import com.vereshchagin.nikolay.home_impl.di.HomeComponent
import com.vereshchagin.nikolay.home_impl.presentation.list.RecommendationListAdapter
import com.vereshchagin.nikolay.home_impl.presentation.list.VacanciesListAdapter
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

    private lateinit var recommendationAdapter: RecommendationListAdapter
    private lateinit var vacancyAdapter: VacanciesListAdapter


    private val homeComponent by scopedComponent {
        HomeComponent.create(appDependenciesProvider())
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        homeComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecommendationList()
        setupVacanciesList()

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

    private fun onStateUpdated(state: HomeState) {
        recommendationAdapter.items = state.data.recommendations
        binding.recommendations.visible(visible = state.data.recommendations.isNotEmpty())

        vacancyAdapter.items = state.data.vacancies

        val vacanciesCount = state.data.moreVacancies
        val moreVacanciesPattern = when (WordDeclension.normalizeType(vacanciesCount)) {
            WordDeclension.DeclensionType.First -> R.string.more_vacancies_first
            WordDeclension.DeclensionType.Second -> R.string.more_vacancies_second
            WordDeclension.DeclensionType.Third -> R.string.more_vacancies_third
        }
        binding.moreVacancies.text = getString(moreVacanciesPattern, state.data.moreVacancies)
    }
}