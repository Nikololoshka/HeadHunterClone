package com.vereshchagin.nikolay.home_impl.presentation.list.recommends

import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.vereshchagin.nikolay.core_api.domain.model.Recommendation
import com.vereshchagin.nikolay.home_impl.databinding.RecommendationListBinding
import com.vereshchagin.nikolay.home_impl.domain.model.HomeItem

fun recommendationDelegate(

) = adapterDelegateViewBinding<HomeItem.HomeRecommendations, HomeItem, RecommendationListBinding>(
    viewBinding = { inflater, parent ->
        RecommendationListBinding.inflate(inflater, parent, false)
    }
) {
    val adapter = ListDelegationAdapter(blockDelegate())
    binding.recommendations.adapter = adapter

    bind {
        adapter.items = item.recommendations
    }
}