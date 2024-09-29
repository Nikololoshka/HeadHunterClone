package com.vereshchagin.nikolay.core_ui.presentation.list

import androidx.recyclerview.widget.DiffUtil
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.vereshchagin.nikolay.core_api.domain.model.Vacancy
import com.vereshchagin.nikolay.core_ui.presentation.list.delegates.vacancyDelegate

class VacanciesListAdapter(
    private val onFavoriteClicked: (id: String) -> Unit
): AsyncListDifferDelegationAdapter<Vacancy>(
    VacancyDiffUtil
) {
    init {
        delegatesManager.addDelegate(vacancyDelegate(::onVacancyFavoriteClicked))
    }

    private fun onVacancyFavoriteClicked(position: Int) {
        val vacancy = items[position]
        onFavoriteClicked(vacancy.id)
    }

    companion object {
        object VacancyDiffUtil : DiffUtil.ItemCallback<Vacancy>() {
            override fun areItemsTheSame(oldItem: Vacancy, newItem: Vacancy): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Vacancy, newItem: Vacancy): Boolean {
                return  oldItem == newItem
            }
        }
    }
}