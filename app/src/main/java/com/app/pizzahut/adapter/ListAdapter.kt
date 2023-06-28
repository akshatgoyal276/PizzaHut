package com.app.pizzahut.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.pizzahut.databinding.ListItemLayoutBinding
import com.app.pizzahut.utils.onClick
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ListAdapter @Inject constructor() :
    RecyclerView.Adapter<ListAdapter.ListItemBindViewHolder>() {

    private var list = listOf<String>()
    var onClick: (String) -> Unit = { }

    fun setAdapterList(newList: List<String>) {
        list = newList
        notifyItemRangeChanged(0, list.size)
    }

    inner class ListItemBindViewHolder(private val binding: ListItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: String, position: Int) {
            binding.tvText.text = "$position Item"
            binding.tvText.onClick {
                onClick(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemBindViewHolder {
        val binding =
            ListItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListItemBindViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ListItemBindViewHolder, position: Int) {
        holder.bind(list[position], position)
    }
}