package com.vereshchagin.nikolay.hh_clone.core_impl.data.mapper

import com.vereshchagin.nikolay.hh_clone.core_impl.data.api.responces.HeadHunterResponse
import com.vereshchagin.nikolay.hh_clone.core_api.domain.model.HeadHunterData


fun HeadHunterResponse.toData(): HeadHunterData {
    return HeadHunterData(offers, vacancies)
}