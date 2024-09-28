package com.vereshchagin.nikolay.home_impl.presentation.list.delegates

import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.vereshchagin.nikolay.core_api.domain.model.Recommendation
import com.vereshchagin.nikolay.core_ui.presentation.gone
import com.vereshchagin.nikolay.core_ui.presentation.show
import com.vereshchagin.nikolay.home_impl.R
import com.vereshchagin.nikolay.home_impl.databinding.RecommendationBlockBinding

fun recommendationDelegate(

) = adapterDelegateViewBinding<Recommendation, Recommendation, RecommendationBlockBinding>(
    viewBinding = { inflater, parent ->
        RecommendationBlockBinding.inflate(inflater, parent, false)
    }
) {
    bind {
        if (item.id != null) {
            binding.icon.show()
            binding.icon.setImageResource(
                when (item.id) {
                    "near_vacancies" -> R.drawable.near_vacancies
                    "level_up_resume" -> R.drawable.level_up_resume
                    "temporary_job" -> R.drawable.temporary_job
                    else -> 0
                }
            )
        } else {
            binding.icon.gone()
        }

        binding.content.text = item.title.trim()
        binding.content.maxLines = if (item.button != null) 2 else 3

        if (item.button != null) {
            binding.link.show()
            binding.link.text = item.button!!.text
        } else {
            binding.link.gone()
        }
    }
}