package com.example.myapplication.remote.retrofit

import com.example.myapplication.local.moreDetails.MoreDetailsResponse
import retrofit2.Response
import retrofit2.http.GET
const val BASE_URL_MOREDEATILS="https://run.mocky.io/v3/15304f12-3fe9-411e-bd2f-c71d3128909d/"
interface MoreDetailsApi {
    @GET(".")
    suspend fun getMoreTabDeatils():Response<MoreDetailsResponse>
}