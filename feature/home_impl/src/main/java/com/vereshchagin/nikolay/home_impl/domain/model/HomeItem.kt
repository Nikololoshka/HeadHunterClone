package com.vereshchagin.nikolay.home_impl.domain.model

import com.vereshchagin.nikolay.core_api.domain.model.Recommendation
import com.vereshchagin.nikolay.core_api.domain.model.Vacancy

sealed interface HomeItem {

    val type: Int

    data object HomeSearchBar : HomeItem {
        override val type = 0
    }

    data class HomeRecommendations(val recommendations: List<Recommendation>) : HomeItem {
        override val type = 1
    }

    data class HomeVacancy(val vacancy: Vacancy) : HomeItem {
        override val type = 2
    }

    data class HomeMoreVacancy(val amount: Int) : HomeItem {
        override val type = 3
    }
}