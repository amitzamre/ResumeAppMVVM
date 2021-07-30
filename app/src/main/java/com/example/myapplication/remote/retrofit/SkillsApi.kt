package com.example.myapplication.remote.retrofit

import com.example.myapplication.local.skills.SkillResponse
import retrofit2.Response
import retrofit2.http.GET


const val BASE_URL_SKILL="https://run.mocky.io/v3/ad0a77ba-639b-4775-ac8a-6894aea76a80/"
interface SkillsApi {
    @GET(".")
    suspend fun getSkillTabDeatails():Response<SkillResponse>
}