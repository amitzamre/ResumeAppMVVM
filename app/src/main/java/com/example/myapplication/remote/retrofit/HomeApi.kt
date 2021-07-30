package com.example.myapplication.remote.retrofit

import com.example.myapplication.local.home.HomeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

const val BASE_URL = "https://run.mocky.io/v3/9076c833-3ae9-44f8-9db3-2259fb4bd437/"
interface HomeApi {
    @GET("{apiStr}")
    suspend fun getHomeTabDeatils(
        @Header("Content-Type") str: String,
        @Path("apiStr") apiStr: String
    ):Response<HomeResponse>
}