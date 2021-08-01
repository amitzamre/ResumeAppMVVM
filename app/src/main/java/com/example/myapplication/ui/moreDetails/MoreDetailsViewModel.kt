package com.example.myapplication.ui.moreDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.local.moreDetails.MoreDetailsResponse
import com.example.myapplication.local.moreDetails.MoreDetailsResponseRepo
import com.example.myapplication.local.projects.ProjectResponse
import com.example.myapplication.util.Events
import com.example.myapplication.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoreDetailsViewModel @Inject constructor(private val moreDetailsRepo:MoreDetailsResponseRepo) : ViewModel() {

    private val _moreDetailsResponse = MutableLiveData<Events<Result<MoreDetailsResponse>>>()
    val moreDetailsResponse: LiveData<Events<Result<MoreDetailsResponse>>> = _moreDetailsResponse


    fun getMoreDetailsResponse()=viewModelScope.launch {

        _moreDetailsResponse.postValue(Events(moreDetailsRepo.getMoreDetailsResponse()))

    }
}