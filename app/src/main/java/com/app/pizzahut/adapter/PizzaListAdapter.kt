package com.app.pizzahut.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.pizzahut.data.modals.dataModals.Pizza
import com.app.pizzahut.databinding.PizzaListItemBinding
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PizzaListAdapter @Inject constructor() :
    RecyclerView.Adapter<PizzaListAdapter.PizzaListItemBindViewHolder>() {

    private var list = listOf<Pizza>()
    var onClick: (String) -> Unit = { }

    fun setAdapterList(newList: List<Pizza>) {
        list = newList
        notifyItemRangeChanged(0, list.size)
    }

    inner class PizzaListItemBindViewHolder(private val binding: PizzaListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Pizza, position: Int) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaListItemBindViewHolder {
        val binding =
            PizzaListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PizzaListItemBindViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: PizzaListItemBindViewHolder, position: Int) {
        holder.bind(list[position], position)
    }
}