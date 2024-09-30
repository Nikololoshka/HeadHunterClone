package com.vereshchagin.nikolay.hh_clone.core_impl.data.api.responces

import com.vereshchagin.nikolay.hh_clone.core_api.domain.model.Recommendation
import com.vereshchagin.nikolay.hh_clone.core_api.domain.model.Vacancy

data class HeadHunterResponse(
    val offers: List<Recommendation>,
    val vacancies: List<Vacancy>
)