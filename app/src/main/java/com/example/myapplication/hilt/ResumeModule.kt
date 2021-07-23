package com.example.myapplication.hilt

import com.example.myapplication.local.HomeResponseRepo
import com.example.myapplication.remote.retrofit.HomeApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.nio.file.Paths
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object ResumeModule {
    @Provides
    @Singleton
    fun provideHomeTabDetailApi ():HomeApi{


        return Retrofit.Builder().baseUrl("../assets/homeResponse.json").addConverterFactory(GsonConverterFactory.create()).build().create(HomeApi::class.java)
    }
    @Provides
    @Singleton
    fun provideHomeRepo(homeApi:HomeApi):HomeResponseRepo{
        return HomeResponseRepo(homeApi)

    }
}