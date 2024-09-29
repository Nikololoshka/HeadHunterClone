package com.vereshchagin.nikolay.core.data.mapper

import com.vereshchagin.nikolay.core.data.api.responces.HeadHunterResponse
import com.vereshchagin.nikolay.core_api.domain.model.HeadHunterData


fun HeadHunterResponse.toData(): HeadHunterData {
    return HeadHunterData(offers, vacancies)
}