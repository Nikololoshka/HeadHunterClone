package com.vereshchagin.nikolay.home_impl.presentation.list.vacancy

import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.vereshchagin.nikolay.core_ui.databinding.VacancyBlockBinding
import com.vereshchagin.nikolay.home_impl.domain.model.HomeItem

fun vacancyDelegate(

) = adapterDelegateViewBinding<HomeItem.HomeVacancy, HomeItem, VacancyBlockBinding>(
    viewBinding = { inflater, parent ->
        VacancyBlockBinding.inflate(inflater, parent, false)
    }
) {
    bind {
        with(binding) {
            with(item) {
                currentViewers.text = vacancy.lookingNumber.toString()
                vacancyTitle.text = vacancy.title
                vacancyCity.text = vacancy.address.town
                companyName.text = vacancy.company
                experience.text = vacancy.experience.previewText
                publishDate.text = vacancy.publishDate
            }
        }
    }
}