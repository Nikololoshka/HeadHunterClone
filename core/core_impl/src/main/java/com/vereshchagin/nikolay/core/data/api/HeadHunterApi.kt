package com.vereshchagin.nikolay.core.data.api

import com.vereshchagin.nikolay.core.data.model.HeadHunterResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface HeadHunterApi {

    @GET
    suspend fun fetch(@Url url: String): HeadHunterResponse
}