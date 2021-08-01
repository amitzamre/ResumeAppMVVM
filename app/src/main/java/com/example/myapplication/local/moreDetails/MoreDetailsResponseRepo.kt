package com.example.myapplication.local.moreDetails

import android.util.Log
import com.example.myapplication.local.projects.ProjectResponse
import com.example.myapplication.remote.retrofit.MoreDetailsApi
import com.example.myapplication.util.Result
import com.example.myapplication.util.Status
import kotlin.Exception

class MoreDetailsResponseRepo(private val moreDetailsApi:MoreDetailsApi) {
    suspend fun getMoreDetailsResponse():Result<MoreDetailsResponse>{
        return try{
            val response=moreDetailsApi.getMoreTabDeatils()
            return Result(Status.SUCCESS,response.body(),null)
        }catch (e:Exception){
            return Result(Status.ERROR,null,null)
        }
    }
}