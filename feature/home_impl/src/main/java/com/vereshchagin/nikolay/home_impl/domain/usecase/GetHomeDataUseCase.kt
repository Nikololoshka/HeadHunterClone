package com.vereshchagin.nikolay.home_impl.domain.usecase


import com.vereshchagin.nikolay.core_api.domain.repository.HeadHunterRemoteSource
import com.vereshchagin.nikolay.home_impl.domain.model.HomeItem
import javax.inject.Inject

class GetHomeDataUseCase @Inject constructor(
    private val repository: HeadHunterRemoteSource
) {

    suspend operator fun invoke(): List<HomeItem> {
        val items = mutableListOf<HomeItem>(HomeItem.HomeSearchBar)

        val data = repository.fetchData()
        items += HomeItem.HomeRecommendations(data.recommendations)
        items += data.vacancies.subList(0, 3).map { HomeItem.HomeVacancy(it) }
        items += HomeItem.HomeMoreVacancy(data.vacancies.size)

        return items
    }
}