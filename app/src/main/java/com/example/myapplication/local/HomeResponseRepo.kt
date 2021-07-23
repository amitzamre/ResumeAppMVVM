package com.example.myapplication.local

import android.util.Log
import com.example.myapplication.remote.retrofit.HomeApi
import com.example.myapplication.util.Result
import com.example.myapplication.util.Status

class HomeResponseRepo (private val homeApi: HomeApi) {

    suspend fun getHomeTabResponse():Result<HomeResponse>{
        return try {
            val response = homeApi.getHomeTabDeatils()
            return Result(Status.SUCCESS, response.body(), null)

        } catch (e: Exception) {
            Log.d("TAG", "getNumberFact: ${e.message}")
            Result(Status.ERROR, null, null)
        }
    }
}