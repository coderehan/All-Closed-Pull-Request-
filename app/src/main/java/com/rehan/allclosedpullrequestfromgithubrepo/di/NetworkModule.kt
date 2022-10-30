package com.rehan.allclosedpullrequestfromgithubrepo.di

import com.rehan.allclosedpullrequestfromgithubrepo.api.PullRequestAPI
import com.rehan.allclosedpullrequestfromgithubrepo.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesPullRequestAPI(retrofit: Retrofit): PullRequestAPI {
        return retrofit.create(PullRequestAPI::class.java)
    }
}