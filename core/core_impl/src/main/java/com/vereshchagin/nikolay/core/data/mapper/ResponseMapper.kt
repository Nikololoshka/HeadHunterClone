package com.vereshchagin.nikolay.core.data.mapper

import com.vereshchagin.nikolay.core.data.model.HeadHunterResponse
import com.vereshchagin.nikolay.core_api.domain.model.HeadHunterData


fun HeadHunterResponse.toData(): HeadHunterData {
    return HeadHunterData(offers, vacancies)
}