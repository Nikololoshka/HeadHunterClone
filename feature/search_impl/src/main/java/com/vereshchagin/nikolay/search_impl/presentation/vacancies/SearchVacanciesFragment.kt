package com.vereshchagin.nikolay.search_impl.presentation.vacancies

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.vereshchagin.nikolay.core_ui.presentation.BaseFragment
import com.vereshchagin.nikolay.search_impl.databinding.FragmentSearchVacanciesBinding

class SearchVacanciesFragment: BaseFragment<FragmentSearchVacanciesBinding>(
    FragmentSearchVacanciesBinding::inflate
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}