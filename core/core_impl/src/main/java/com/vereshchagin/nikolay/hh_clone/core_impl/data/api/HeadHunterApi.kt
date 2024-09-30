package com.vereshchagin.nikolay.hh_clone.core_impl.data.api

import com.vereshchagin.nikolay.hh_clone.core_impl.data.api.responces.HeadHunterResponse
import retrofit2.http.GET
import retrofit2.http.Url

interface HeadHunterApi {

    @GET
    suspend fun fetch(@Url url: String): HeadHunterResponse
}