package com.example.myapplication.local.home

import com.example.myapplication.util.Result

interface DefaultHomeResponseRepo {
    suspend fun getHomeTabResponse(): Result<HomeResponse>
}