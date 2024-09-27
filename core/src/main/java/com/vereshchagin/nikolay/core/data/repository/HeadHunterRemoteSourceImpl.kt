package com.vereshchagin.nikolay.core.data.repository

import com.vereshchagin.nikolay.core.data.api.HeadHunterApi
import com.vereshchagin.nikolay.core.data.mapper.toData
import com.vereshchagin.nikolay.core_api.domain.model.HeadHunterData
import com.vereshchagin.nikolay.core_api.domain.repository.HeadHunterRemoteSource
import retrofit2.await
import javax.inject.Inject

private const val END_POINT = "https://drive.usercontent.google.com/u/0/uc?id=1z4TbeDkbfXkvgpoJprXbN85uCcD7f00r&export=download"

class HeadHunterRemoteSourceImpl @Inject constructor(
    private val api: HeadHunterApi
) : HeadHunterRemoteSource {

    override suspend fun fetchData(): HeadHunterData {
        return api.fetch(END_POINT).toData()
    }
}