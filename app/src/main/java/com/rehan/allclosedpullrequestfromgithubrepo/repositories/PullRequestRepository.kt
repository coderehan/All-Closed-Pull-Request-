package com.rehan.allclosedpullrequestfromgithubrepo.repositories

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rehan.allclosedpullrequestfromgithubrepo.api.PullRequestAPI
import com.rehan.allclosedpullrequestfromgithubrepo.models.PullRequest
import javax.inject.Inject

class PullRequestRepository @Inject constructor(private val pullRequestAPI: PullRequestAPI) {

    private val _pullRequestLiveData = MutableLiveData<List<PullRequest>>()
    val pullRequestLiveData: LiveData<List<PullRequest>>
        get() = _pullRequestLiveData

    suspend fun getPullRequestInfo() {
        val response = pullRequestAPI.getPullRequest()

        if (response.isSuccessful && response.body() != null) {
            _pullRequestLiveData.postValue(response.body())
        }else{
            return
        }
    }

}