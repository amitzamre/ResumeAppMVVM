package com.example.myapplication.remote.retrofit

import com.example.myapplication.local.projects.ProjectResponse
import retrofit2.Response
import retrofit2.http.GET
const val BASE_URL_PROJ_DEATAILS="https://run.mocky.io/v3/8db0da7c-10d9-4def-8990-7014303566dc/"

interface ProjectDetailsApi {
    @GET(".")
    suspend fun getProjectDeatils():Response<ProjectResponse>
}