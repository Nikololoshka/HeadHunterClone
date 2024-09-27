package com.vereshchagin.nikolay.home_impl.presentation.list.recommends

import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.vereshchagin.nikolay.core_api.domain.model.Recommendation
import com.vereshchagin.nikolay.home_impl.databinding.RecommendationBlockBinding

fun blockDelegate(

) = adapterDelegateViewBinding<Recommendation, Recommendation, RecommendationBlockBinding>(
viewBinding = { inflater, parent ->
    RecommendationBlockBinding.inflate(inflater, parent, false)
}) {
    bind {
        binding.content.text = item.title
    }
}