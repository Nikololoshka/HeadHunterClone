package com.vereshchagin.nikolay.hh_clone.core_ui.presentation.list

import androidx.recyclerview.widget.DiffUtil
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.vereshchagin.nikolay.hh_clone.core_api.domain.model.Vacancy
import com.vereshchagin.nikolay.hh_clone.core_ui.presentation.list.delegates.VacancyCardListener
import com.vereshchagin.nikolay.hh_clone.core_ui.presentation.list.delegates.VacancyPayload
import com.vereshchagin.nikolay.hh_clone.core_ui.presentation.list.delegates.vacancyDelegate

class VacanciesListAdapter(
    private val listener: VacanciesListListener
): AsyncListDifferDelegationAdapter<Vacancy>(
    VacancyDiffUtil
), VacancyCardListener {

    init {
        delegatesManager.addDelegate(vacancyDelegate(this))
    }

    override fun onFavoriteClicked(position: Int) {
        val vacancy = items[position]
        listener.onFavoriteClicked(vacancy.id)
    }

    override fun onCardClicked(position: Int) {
        val vacancy = items[position]
        listener.onCardClicked(vacancy.id)
    }

    companion object {
        object VacancyDiffUtil : DiffUtil.ItemCallback<Vacancy>() {
            override fun areItemsTheSame(oldItem: Vacancy, newItem: Vacancy): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Vacancy, newItem: Vacancy): Boolean {
                return  oldItem == newItem
            }

            override fun getChangePayload(oldItem: Vacancy, newItem: Vacancy): Any? {
                if (oldItem.isFavorite != newItem.isFavorite) {
                    return VacancyPayload(newItem.isFavorite)
                }
                return super.getChangePayload(oldItem, newItem)
            }
        }
    }
}