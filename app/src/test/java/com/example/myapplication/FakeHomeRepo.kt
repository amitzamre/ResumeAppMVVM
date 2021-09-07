package com.example.myapplication

import com.example.myapplication.local.home.DefaultHomeResponseRepo
import com.example.myapplication.local.home.HomeResponse
import com.example.myapplication.local.home.HomeResponseRepo
import com.example.myapplication.util.Result
import com.example.myapplication.util.Status

class FakeHomeRepo: DefaultHomeResponseRepo {
    override suspend fun getHomeTabResponse(): Result<HomeResponse> {
        val response =HomeResponse("AMit Zamre","BE","Java,Kotlin")
        return Result(Status.SUCCESS, response, null)
    }
}