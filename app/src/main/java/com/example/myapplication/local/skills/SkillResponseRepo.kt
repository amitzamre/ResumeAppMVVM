package com.example.myapplication.local.skills

import com.example.myapplication.remote.retrofit.SkillsApi
import com.example.myapplication.util.Result
import com.example.myapplication.util.Status

class SkillResponseRepo (private val skillApi:SkillsApi){
 suspend fun getSkillTabResponse():Result<SkillResponse>{
     return try{
         val response =skillApi.getSkillTabDeatails()
         return Result(Status.SUCCESS,response.body(),null)
     }catch (e:Exception){
         return Result(Status.ERROR,null,null)
     }
 }
}