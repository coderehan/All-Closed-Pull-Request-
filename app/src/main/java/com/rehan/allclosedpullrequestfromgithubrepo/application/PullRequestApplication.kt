package com.rehan.allclosedpullrequestfromgithubrepo.application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PullRequestApplication: Application() {

    override fun onCreate() {
        super.onCreate()
    }
}