package com.vereshchagin.nikolay.home_impl.presentation.list

import androidx.recyclerview.widget.DiffUtil
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.vereshchagin.nikolay.core_api.domain.model.Recommendation
import com.vereshchagin.nikolay.home_impl.presentation.list.delegates.recommendationDelegate

class RecommendationListAdapter(

): AsyncListDifferDelegationAdapter<Recommendation>(
    RecommendationDiffUtil
) {
    init {
        delegatesManager.addDelegate(recommendationDelegate())
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