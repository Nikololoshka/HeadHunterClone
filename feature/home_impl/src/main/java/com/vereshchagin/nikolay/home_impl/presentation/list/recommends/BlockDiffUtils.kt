package com.vereshchagin.nikolay.home_impl.presentation.list.recommends

import androidx.recyclerview.widget.DiffUtil
import com.vereshchagin.nikolay.core_api.domain.model.Recommendation

object BlockDiffUtils : DiffUtil.ItemCallback<Recommendation>() {

    override fun areItemsTheSame(oldItem: Recommendation, newItem: Recommendation): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Recommendation, newItem: Recommendation): Boolean {
        return oldItem == newItem
    }
}