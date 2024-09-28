package com.vereshchagin.nikolay.home_impl.domain.usecase


import com.vereshchagin.nikolay.core_api.domain.repository.HeadHunterRemoteSource
import com.vereshchagin.nikolay.home_impl.domain.model.SearchHomeData
import javax.inject.Inject

class GetSearchHomeDataUseCase @Inject constructor(
    private val repository: HeadHunterRemoteSource
) {

    suspend operator fun invoke(): SearchHomeData {
        val data = repository.fetchData()

        return SearchHomeData(
            recommendations = data.recommendations,
            vacancies = data.vacancies.subList(0, 3),
            moreVacancies = data.vacancies.size
        )
    }
}