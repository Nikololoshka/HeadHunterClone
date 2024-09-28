package com.vereshchagin.nikolay.core_api.domain.repository

import com.vereshchagin.nikolay.core_api.domain.model.HeadHunterData

interface HeadHunterRemoteSource {

    suspend fun fetchData(): HeadHunterData
}