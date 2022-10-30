package com.rehan.allclosedpullrequestfromgithubrepo.api

import com.rehan.allclosedpullrequestfromgithubrepo.models.PullRequest
import retrofit2.Response
import retrofit2.http.GET

interface PullRequestAPI {

    @GET("repos/coderehan/Notesify/pulls?state=closed")
    suspend fun getPullRequest(): Response<List<PullRequest>>
}