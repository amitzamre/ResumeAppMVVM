package com.example.myapplication.ui.home


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.local.home.HomeResponse
import com.example.myapplication.local.home.HomeResponseRepo
import com.example.myapplication.util.Events
import com.example.myapplication.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repo: HomeResponseRepo): ViewModel() {


    //private  val _homeResponse=MutableLiveData<Events<Result<HomeResponse>>>()
    //val homeResponse:LiveData<Events<Result<HomeResponse>>>=_homeResponse

    private val _homeResponse = MutableLiveData<Events<Result<HomeResponse>>>()
    val homeResponse: LiveData<Events<Result<HomeResponse>>> = _homeResponse

    fun getHomeReposne()=viewModelScope.launch {
        _homeResponse.postValue(Events(repo.getHomeTabResponse()))

    }
}