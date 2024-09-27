package com.vereshchagin.nikolay.home_impl.presentation.list.vacancy

import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.vereshchagin.nikolay.core_ui.databinding.VacancyBlockBinding
import com.vereshchagin.nikolay.home_impl.databinding.MoreVacancyBinding
import com.vereshchagin.nikolay.home_impl.domain.model.HomeItem

fun moreVacancyDelegate(

) = adapterDelegateViewBinding<HomeItem.HomeMoreVacancy, HomeItem, MoreVacancyBinding>(
    viewBinding = { inflater, parent ->
        MoreVacancyBinding.inflate(inflater, parent, false)
    }
) {
    bind {
        binding.more.text = item.amount.toString()
    }
}