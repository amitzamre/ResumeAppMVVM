package com.example.myapplication.remote.retrofit

import com.example.myapplication.local.projects.ProjectResponse
import retrofit2.Response
import retrofit2.http.GET
const val BASE_URL_PROJ_DEATAILS="https://run.mocky.io/v3/03688cf4-7e86-44e1-a379-c2a90bcaff59/"
interface ProjectDetailsApi {
    @GET(".")
    suspend fun getProjectDeatils():Response<ProjectResponse>
}