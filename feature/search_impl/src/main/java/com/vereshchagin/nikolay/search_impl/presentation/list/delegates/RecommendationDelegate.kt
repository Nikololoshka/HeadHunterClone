package com.vereshchagin.nikolay.search_impl.presentation.list.delegates

import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.vereshchagin.nikolay.core_api.domain.model.Recommendation
import com.vereshchagin.nikolay.core_ui.presentation.utils.gone
import com.vereshchagin.nikolay.core_ui.presentation.utils.show
import com.vereshchagin.nikolay.search_impl.R
import com.vereshchagin.nikolay.search_impl.databinding.RecommendationBlockBinding

fun recommendationDelegate(
    onItemClicked: (position: Int) -> Unit
) = adapterDelegateViewBinding<Recommendation, Recommendation, RecommendationBlockBinding>(
    viewBinding = { inflater, parent ->
        RecommendationBlockBinding.inflate(inflater, parent, false)
    }
) {
    itemView.setOnClickListener { onItemClicked(bindingAdapterPosition) }

    bind {
        val recommendationIcon = when (item.id) {
            "near_vacancies" -> R.drawable.rec_near_vacancies
            "level_up_resume" -> R.drawable.rec_level_up_resume
            "temporary_job" -> R.drawable.rec_temporary_job
            else -> null
        }
        if (recommendationIcon != null) {
            binding.icon.setImageResource(recommendationIcon)
            binding.icon.show()
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