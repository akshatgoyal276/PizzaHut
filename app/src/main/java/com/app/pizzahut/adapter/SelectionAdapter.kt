package com.app.pizzahut.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.pizzahut.databinding.SelectorItemBinding
import com.app.pizzahut.utils.onClick
import javax.inject.Inject

data class SelectionItem(
    val id: String, val name: String
)


class SelectionAdapter @Inject constructor() :
    RecyclerView.Adapter<SelectionAdapter.SelectionBindViewHolder>() {

    private var list = listOf<SelectionItem>()
    var selectedItemId: String = ""
    var onClick: (String) -> Unit = { }

    fun setAdapterList(newList: List<SelectionItem>) {
        list = newList
        notifyItemRangeChanged(0, list.size)
    }

    fun setSelection(item: SelectionItem, position: Int) {
        selectedItemId = item.id
        notifyItemRangeChanged(0, list.size)
    }


    inner class SelectionBindViewHolder(private val binding: SelectorItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: SelectionItem, position: Int) {
            binding.apply {
                itemName.text = item.name
                isSelected = (item.id == selectedItemId)
                itemCard.onClick {
                    setSelection(item, position)
                    onClick(item.id)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectionBindViewHolder {
        val binding =
            SelectorItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SelectionBindViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: SelectionBindViewHolder, position: Int) {
        holder.bind(list[position], position)
    }
}