package com.example.myapplication.ui.project

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.local.projects.ProjectResponse
import com.example.myapplication.local.projects.ProjectResponseRepo
import com.example.myapplication.util.Events
import com.example.myapplication.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProjectViewModel @Inject constructor(private val projectResRepo:ProjectResponseRepo): ViewModel() {

    private val _projectResponse = MutableLiveData<Events<Result<ProjectResponse>>>()
    val projectResponse: LiveData<Events<Result<ProjectResponse>>> = _projectResponse

    fun getProjectResponse()=viewModelScope.launch {

        _projectResponse.postValue(Events(projectResRepo.getProjectDetailsResponse()))

    }
}