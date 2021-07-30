package com.example.myapplication.local.skills

import android.util.Log
import com.example.myapplication.remote.retrofit.SkillsApi
import com.example.myapplication.util.Result
import com.example.myapplication.util.Status

class SkillResponseRepo (private val skillApi:SkillsApi){

 suspend fun getSkillTabResponse():Result<SkillResponse>{
     return try{
         Log.d("Inside skill repo","inside skill repo")
         val response =skillApi.getSkillTabDeatails()
         Log.d("skill response skilrepo","${response.body()?.skills?.get(0)}")
         return Result(Status.SUCCESS,response.body(),null)
     }catch (e:Exception){
         Log.e("error calingskll api","${e.toString()}")
         return Result(Status.ERROR,null,null)
     }
 }
}