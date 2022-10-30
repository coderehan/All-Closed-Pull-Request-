package com.rehan.allclosedpullrequestfromgithubrepo.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.rehan.allclosedpullrequestfromgithubrepo.R
import com.rehan.allclosedpullrequestfromgithubrepo.adapters.PullRequestAdapter
import com.rehan.allclosedpullrequestfromgithubrepo.databinding.ActivityMainBinding
import com.rehan.allclosedpullrequestfromgithubrepo.viewmodels.PullRequestViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var pullRequestViewModel: PullRequestViewModel
    private lateinit var pullRequestAdapter: PullRequestAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        pullRequestViewModel = ViewModelProvider(this)[PullRequestViewModel::class.java]
        pullRequestViewModel.getPullRequestInfo()
        preparePullRequestInfoRecyclerView()
        observePullRequestLiveData()
    }

    private fun preparePullRequestInfoRecyclerView() {
        binding.progressBar.visibility = View.VISIBLE
        pullRequestAdapter = PullRequestAdapter()
        binding.rvList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = pullRequestAdapter
        }
    }

    private fun observePullRequestLiveData() {
       pullRequestViewModel.pullRequestLiveData.observe(this, Observer {
           binding.progressBar.visibility = View.GONE
           pullRequestAdapter.setPullRequestList(it)
       })
    }


}