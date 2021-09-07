package com.example.myapplication.local.home

import android.util.Log
import com.example.myapplication.remote.retrofit.HomeApi
import com.example.myapplication.util.Result
import com.example.myapplication.util.Status

class HomeResponseRepo (private val homeApi: HomeApi) :DefaultHomeResponseRepo{

   override suspend fun getHomeTabResponse():Result<HomeResponse>{
        return try {
            val response = homeApi.getHomeTabDeatils("application/json", "9076c833-3ae9-44f8-9db3-2259fb4bd437/")
            return Result(Status.SUCCESS, response.body(), null)

        } catch (e: Exception) {
            Log.d("TAG", "getNumberFact: ${e.message}")
            Result(Status.ERROR, null, null)
        }
    }
}