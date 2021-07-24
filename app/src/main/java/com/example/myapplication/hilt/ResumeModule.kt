package com.example.myapplication.hilt

import android.util.Log
import com.example.myapplication.local.HomeResponseRepo
import com.example.myapplication.remote.retrofit.BASE_URL
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

        Log.d("BASE URL ", "home resposne: ${BASE_URL}")
        return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build().create(HomeApi::class.java)

    }
    @Provides
    @Singleton
    fun provideHomeRepo(homeApi:HomeApi):HomeResponseRepo {
        return HomeResponseRepo(homeApi)
    }


}