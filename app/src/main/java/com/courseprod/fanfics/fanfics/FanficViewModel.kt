package com.courseprod.fanfics.fanfics

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.courseprod.fanfics.data.FanficRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FanficViewModel @Inject constructor(
    repository: FanficRepository
) : ViewModel() {

    val fanfics = repository.getFanfics().asLiveData()
}