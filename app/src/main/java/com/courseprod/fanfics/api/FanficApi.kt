package com.courseprod.fanfics.api

import com.courseprod.fanfics.data.Fanfic
import retrofit2.http.GET

interface FanficApi {

    companion object {
        const val BASE_URL = "http://192.168.2.5:8080/api/"
    }

    @GET("fanfics")
    suspend fun getFanfics(): List<Fanfic>
}