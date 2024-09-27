package com.vereshchagin.nikolay.home_impl.domain.usecase


import com.vereshchagin.nikolay.core_api.domain.repository.HeadHunterRemoteSource
import com.vereshchagin.nikolay.home_impl.domain.model.HomeData
import javax.inject.Inject

class GetHomeDataUseCase @Inject constructor(
    private val repository: HeadHunterRemoteSource
) {

    suspend operator fun invoke(): HomeData {
        val data = repository.fetchData()
        return HomeData(data.recommendations, data.vacancies)
    }
}