package com.example.myapplication.ui.skill

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.local.HomeResponse
import com.example.myapplication.local.skills.SkillResponse
import com.example.myapplication.local.skills.SkillResponseRepo
import com.example.myapplication.util.Events
import com.example.myapplication.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SkillViewModel @Inject constructor(private val repo:SkillResponseRepo) : ViewModel() {

    private val _skillResponse = MutableLiveData<Events<Result<SkillResponse>>>()
    val skillResponse: LiveData<Events<Result<SkillResponse>>> = _skillResponse

    fun getSkillResponse()=viewModelScope.launch {

        _skillResponse.postValue(Events(repo.getSkillTabResponse()))

    }
}