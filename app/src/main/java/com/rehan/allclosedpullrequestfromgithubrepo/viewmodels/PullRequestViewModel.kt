package com.rehan.allclosedpullrequestfromgithubrepo.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rehan.allclosedpullrequestfromgithubrepo.models.PullRequest
import com.rehan.allclosedpullrequestfromgithubrepo.repositories.PullRequestRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PullRequestViewModel @Inject constructor(private val pullRequestRepository: PullRequestRepository)  : ViewModel(){

    val pullRequestLiveData get() = pullRequestRepository.pullRequestLiveData

    fun getPullRequestInfo() {
        viewModelScope.launch {
            pullRequestRepository.getPullRequestInfo()
        }
    }

}