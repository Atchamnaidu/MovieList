package com.example.movielist.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.movielist.BR
import com.example.movielist.R
import com.example.movielist.databinding.ListItemBinding
import com.example.movielist.model.ShowDetails

class MovieListAdapter : RecyclerView.Adapter<MovieListAdapter.ViewHolder>() {

    private var showList: List<ShowDetails> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<ShowDetails>) {
        showList = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ListItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.list_item,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(showList[position])
    }

    override fun getItemCount(): Int {
        return showList.size
    }


    class ViewHolder(private var binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(showDetails: ShowDetails) {
            binding.setVariable(BR.score, showDetails.score.toString())
            binding.setVariable(BR.show, showDetails.show)
        }

    }
}