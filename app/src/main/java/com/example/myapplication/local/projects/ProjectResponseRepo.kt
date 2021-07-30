package com.example.myapplication.local.projects

import com.example.myapplication.remote.retrofit.ProjectDetailsApi
import com.example.myapplication.util.Result
import com.example.myapplication.util.Status

class ProjectResponseRepo(private val projectDetailsApi:ProjectDetailsApi) {

    suspend fun getProjectDetailsResponse():Result<ProjectResponse>{
        return try{
            val response=projectDetailsApi.getProjectDeatils()
            return Result(Status.SUCCESS,response.body(),null)
        }catch (e:Exception){
            return Result(Status.ERROR,null,null)
        }
    }
}