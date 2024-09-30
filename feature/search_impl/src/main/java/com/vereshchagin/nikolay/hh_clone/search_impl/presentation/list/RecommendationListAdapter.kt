package com.vereshchagin.nikolay.hh_clone.search_impl.presentation.list

import androidx.recyclerview.widget.DiffUtil
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.vereshchagin.nikolay.hh_clone.core_api.domain.model.Recommendation
import com.vereshchagin.nikolay.hh_clone.search_impl.presentation.list.delegates.recommendationDelegate

class RecommendationListAdapter(
    private val onItemClicked: (item: Recommendation) -> Unit
): AsyncListDifferDelegationAdapter<Recommendation>(
    RecommendationDiffUtil
) {
    init {
        delegatesManager.addDelegate(recommendationDelegate(::onRecommendationClicked))
    }

    private fun onRecommendationClicked(position: Int) {
        val item = items[position]
        onItemClicked(item)
    }

    companion object {
        object RecommendationDiffUtil : DiffUtil.ItemCallback<Recommendation>() {
            override fun areItemsTheSame(oldItem: Recommendation, newItem: Recommendation): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Recommendation, newItem: Recommendation): Boolean {
                return  oldItem == newItem
            }
        }
    }
}