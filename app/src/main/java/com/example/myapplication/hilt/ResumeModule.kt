package com.example.myapplication.hilt

import android.util.Log
import com.example.myapplication.local.home.DefaultHomeResponseRepo
import com.example.myapplication.local.home.HomeResponseRepo
import com.example.myapplication.local.moreDetails.MoreDetailsResponseRepo
import com.example.myapplication.local.projects.ProjectResponseRepo
import com.example.myapplication.local.skills.SkillResponseRepo
import com.example.myapplication.remote.retrofit.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object ResumeModule {
    @Provides
    @Singleton
    fun provideHomeTabDetailApi ():HomeApi{

        Log.d("BASE URL ", "home resposne: ${BASE_URL}")
        return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build().create(HomeApi::class.java)

    }
    @Provides
    @Singleton
    fun provideHomeRepo(homeApi:HomeApi): DefaultHomeResponseRepo {
        return HomeResponseRepo(homeApi)
    }
    @Provides
    @Singleton
    fun provideSkillTabDeatilsApi():SkillsApi{
        Log.d("BASE URL Skill","Skill request url: ${BASE_URL_SKILL}")
        return Retrofit.Builder().baseUrl(BASE_URL_SKILL).addConverterFactory(GsonConverterFactory.create()).build().create(SkillsApi::class.java)
    }
    @Provides
    @Singleton
    fun provideSkillRepo(skillApi:SkillsApi):SkillResponseRepo{
        return SkillResponseRepo(skillApi)
    }
    @Provides
    @Singleton
    fun provideProjectDetailsApi(): ProjectDetailsApi{
        return Retrofit.Builder().baseUrl(BASE_URL_PROJ_DEATAILS).addConverterFactory(GsonConverterFactory.create()).build().create(ProjectDetailsApi::class.java)
    }
    @Provides
    @Singleton
    fun provideProjectDetailsRepo(projectDetailsApi:ProjectDetailsApi):ProjectResponseRepo{
        return ProjectResponseRepo(projectDetailsApi)
    }
    @Provides
    @Singleton
    fun provideMoreDetailsApi():MoreDetailsApi{
        return Retrofit.Builder().baseUrl(BASE_URL_MOREDEATILS).addConverterFactory(GsonConverterFactory.create()).build().create(MoreDetailsApi::class.java)
    }
    @Provides
    @Singleton
    fun provideMoreDetailsRepo(moreDeatislApi:MoreDetailsApi):MoreDetailsResponseRepo{
        return MoreDetailsResponseRepo(moreDeatislApi)
    }
}