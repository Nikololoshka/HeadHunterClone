package com.vereshchagin.nikolay.home_impl.domain.usecase


import com.vereshchagin.nikolay.core_api.domain.repository.HeadHunterRemoteSource
import com.vereshchagin.nikolay.home_impl.domain.model.HomePageData
import javax.inject.Inject

class GetHomeDataUseCase @Inject constructor(
    private val repository: HeadHunterRemoteSource
) {

    suspend operator fun invoke(): HomePageData {
        val data = repository.fetchData()

        return HomePageData(
            recommendations = data.recommendations,
            vacancies = data.vacancies.subList(0, 3),
            moreVacancies = data.vacancies.size
        )
    }
}