package com.vereshchagin.nikolay.core_ui.presentation.list.delegates

import android.icu.text.SimpleDateFormat
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.vereshchagin.nikolay.core_api.domain.model.Vacancy
import com.vereshchagin.nikolay.core_ui.databinding.VacancyBlockBinding
import com.vereshchagin.nikolay.core_ui.presentation.utils.getPluralsString
import com.vereshchagin.nikolay.core_ui.presentation.utils.gone
import com.vereshchagin.nikolay.core_ui.presentation.utils.show
import java.util.Locale
import com.vereshchagin.nikolay.core_ui.R

fun vacancyDelegate(

) = adapterDelegateViewBinding<Vacancy, Vacancy, VacancyBlockBinding>(
    viewBinding = { inflater, parent ->
        VacancyBlockBinding.inflate(inflater, parent, false)
    }
) {
    bind {
        with(binding) {
            if (item.lookingNumber > 0) {
                currentViewers.text = getPluralsString(R.plurals.looking_vacancy, item.lookingNumber)
                currentViewers.show()
            } else {
                currentViewers.gone()
            }

            binding.favorite.setImageResource(
                if (item.isFavorite) {
                    R.drawable.remove_favorite
                } else {
                    R.drawable.add_favorite
                }
            )

            vacancyTitle.text = item.title

            if (!item.salary.short.isNullOrEmpty()) {
                vacancySalary.text = item.salary.short
                vacancySalary.show()
            } else {
                vacancySalary.gone()
            }

            vacancyCity.text = item.address.town
            companyName.text = item.company
            experience.text = item.experience.previewText

            publishDate.text = formatDate(item.publishedDate)
        }
    }
}

fun formatDate(publishDate: String): String? {
    val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val date = formatter.parse(publishDate)

    val formatter2 = SimpleDateFormat("d MMMM", Locale.forLanguageTag("ru"))
    return formatter2.format(date)
}