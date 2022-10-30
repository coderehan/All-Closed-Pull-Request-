package com.rehan.allclosedpullrequestfromgithubrepo.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rehan.allclosedpullrequestfromgithubrepo.databinding.AdapterItemLayoutBinding
import com.rehan.allclosedpullrequestfromgithubrepo.models.PullRequest

class PullRequestAdapter : RecyclerView.Adapter<PullRequestAdapter.ViewHolder>() {

    private var pullRequestInfoList = ArrayList<PullRequest>()

    fun setPullRequestList(pullRequestInfoList: List<PullRequest>){
        this.pullRequestInfoList = pullRequestInfoList as ArrayList<PullRequest>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = AdapterItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load(pullRequestInfoList[position].user.avatar_url)
            .into(holder.binding.ivUser)

        holder.binding.tvUserName.text = pullRequestInfoList[position].user.name
        holder.binding.tvTitleName.text = pullRequestInfoList[position].title
        holder.binding.tvCreatedAt.text = pullRequestInfoList[position].created_date
        holder.binding.tvClosedAt.text = pullRequestInfoList[position].closed_date
    }

    override fun getItemCount(): Int {
        return pullRequestInfoList.size
    }

    class ViewHolder(val binding: AdapterItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }
}