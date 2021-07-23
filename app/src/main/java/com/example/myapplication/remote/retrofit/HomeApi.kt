package com.example.myapplication.remote.retrofit

import com.example.myapplication.local.HomeResponse
import retrofit2.Response
import retrofit2.http.GET

interface HomeApi {
    @GET
    suspend fun getHomeTabDeatils(

    ):Response<HomeResponse>
}