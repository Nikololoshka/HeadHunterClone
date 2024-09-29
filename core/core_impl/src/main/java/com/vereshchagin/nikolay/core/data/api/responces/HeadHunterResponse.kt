package com.vereshchagin.nikolay.core.data.api.responces

import com.vereshchagin.nikolay.core_api.domain.model.Recommendation
import com.vereshchagin.nikolay.core_api.domain.model.Vacancy

data class HeadHunterResponse(
    val offers: List<Recommendation>,
    val vacancies: List<Vacancy>
)