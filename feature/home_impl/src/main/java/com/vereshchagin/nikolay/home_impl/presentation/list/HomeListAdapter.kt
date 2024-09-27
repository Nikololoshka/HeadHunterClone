package com.vereshchagin.nikolay.home_impl.presentation.list

import androidx.recyclerview.widget.DiffUtil
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.vereshchagin.nikolay.home_impl.domain.model.HomeItem
import com.vereshchagin.nikolay.home_impl.presentation.list.bar.searchBarDelegate
import com.vereshchagin.nikolay.home_impl.presentation.list.recommends.recommendationDelegate
import com.vereshchagin.nikolay.home_impl.presentation.list.vacancy.moreVacancyDelegate
import com.vereshchagin.nikolay.home_impl.presentation.list.vacancy.vacancyDelegate

class HomeListAdapter(

) : AsyncListDifferDelegationAdapter<HomeItem>(
    HomeItemDiffUtil
) {

    init {
        delegatesManager.addDelegate(searchBarDelegate())
        delegatesManager.addDelegate(recommendationDelegate())
        delegatesManager.addDelegate(vacancyDelegate())
        delegatesManager.addDelegate(moreVacancyDelegate())
    }
}


object HomeItemDiffUtil : DiffUtil.ItemCallback<HomeItem>() {
    override fun areItemsTheSame(oldItem: HomeItem, newItem: HomeItem): Boolean {
        return oldItem.type == newItem.type
    }

    override fun areContentsTheSame(oldItem: HomeItem, newItem: HomeItem): Boolean {
        return oldItem == newItem
    }
}