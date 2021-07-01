package com.courseprod.fanfics.fanfics

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.courseprod.fanfics.data.Fanfic
import com.courseprod.fanfics.databinding.FanficItemBinding

import kotlin.coroutines.coroutineContext

class FanficAdapter :
    ListAdapter<Fanfic, FanficAdapter.FanficViewHolder>(FanficComparator()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FanficViewHolder {
        val binding = FanficItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FanficViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FanficViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

    class FanficViewHolder(private val binding: FanficItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(fanfic: Fanfic) {
            binding.apply {

                textViewTitle.text = fanfic.title
                textViewDescription.text = fanfic.description
                textViewTag.text = fanfic.tag
                textViewFandom.text = fanfic.fandom
                itemView.setOnClickListener() {

                }
            }
        }
    }
    class FanficComparator : DiffUtil.ItemCallback<Fanfic>() {
        override fun areItemsTheSame(oldItem: Fanfic, newItem: Fanfic) =
            oldItem.title == newItem.title

        override fun areContentsTheSame(oldItem: Fanfic, newItem: Fanfic) =
            oldItem == newItem
    }


}