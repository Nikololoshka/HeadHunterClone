package com.vereshchagin.nikolay.hh_clone.search_impl.presentation.vacancies

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.vereshchagin.nikolay.hh_clone.core_ui.presentation.fragment.BaseFragment
import com.vereshchagin.nikolay.hh_clone.core_ui.presentation.list.MarginItemDecorator
import com.vereshchagin.nikolay.hh_clone.core_ui.presentation.utils.getPluralsString
import com.vereshchagin.nikolay.hh_clone.module_injector.appDependenciesProvider
import com.vereshchagin.nikolay.hh_clone.module_injector.scopedComponent
import com.vereshchagin.nikolay.hh_clone.search_impl.R
import com.vereshchagin.nikolay.hh_clone.search_impl.databinding.FragmentSearchVacanciesBinding
import com.vereshchagin.nikolay.hh_clone.search_impl.di.SearchComponent
import com.vereshchagin.nikolay.hh_clone.core_ui.presentation.list.VacanciesListAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.vereshchagin.nikolay.hh_clone.core_ui.R as R_core_ui

class SearchVacanciesFragment: BaseFragment<FragmentSearchVacanciesBinding>(
    FragmentSearchVacanciesBinding::inflate
) {

    @Inject
    lateinit var viewModelFactory: SearchVacanciesViewModel.SearchVacanciesViewModelFactory
    private val viewModel by viewModels<SearchVacanciesViewModel> {
        SearchVacanciesViewModel.provideFactory(viewModelFactory)
    }

    private lateinit var vacanciesAdapter: VacanciesListAdapter

    private val searchComponent by scopedComponent {
        SearchComponent.create(appDependenciesProvider())
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        searchComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupVacanciesList()
        setupClickListeners()

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collectLatest(::onStateChanged)
            }
        }
    }

    private fun setupVacanciesList() {
        vacanciesAdapter = VacanciesListAdapter(viewModel::setFavoriteVacancy)
        binding.vacancies.adapter = vacanciesAdapter

        val paddingBottom = resources.getDimensionPixelSize(R_core_ui.dimen.default_screen_margin)
        binding.vacancies.addItemDecoration(MarginItemDecorator(bottom = paddingBottom * 2))
    }

    private fun setupClickListeners() {
        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun onStateChanged(state: SearchVacanciesState) {
        val vacanciesCount =  state.vacancies.size
        binding.vacanciesCounter.text = getPluralsString(R.plurals.vacancies_counter,vacanciesCount)

        vacanciesAdapter.items = state.vacancies
    }
}