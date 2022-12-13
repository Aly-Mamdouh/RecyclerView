package com.ali.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ali.recyclerview.databinding.MatchLayoutBinding

class MatchAdapter(val list: List<Data>, val listener:MatchInteraction):RecyclerView.Adapter<MatchAdapter.MatchViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        val view:View=LayoutInflater.from(parent.context).inflate(R.layout.match_layout,parent,false)
        return MatchViewHolder(view)
    }

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        val ItemsViewModel = list[position]
        holder.binding.team1Tv.text = ItemsViewModel.team1
        holder.binding.team2Tv.text = ItemsViewModel.team2
        holder.binding.scoreTeam1Tv.text = ItemsViewModel.score1.toString()
        holder.binding.scoreTeam2Tv.text = ItemsViewModel.score2.toString()
        holder.binding.team1Tv.setOnClickListener(View.OnClickListener {
            listener.onClickTeamName(ItemsViewModel.team1)
        })
        holder.binding.team2Tv.setOnClickListener(View.OnClickListener {
            listener.onClickTeamName(ItemsViewModel.team2)
        })
        holder.binding.root.setOnClickListener(View.OnClickListener {
            listener.onItemClickListener(ItemsViewModel)
        })
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MatchViewHolder (itemView:View): RecyclerView.ViewHolder(itemView) {
        val binding= MatchLayoutBinding.bind(itemView)
    }
}