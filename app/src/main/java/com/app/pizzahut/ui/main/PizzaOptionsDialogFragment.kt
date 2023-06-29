package com.app.pizzahut.ui.main

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.app.pizzahut.adapter.SelectionAdapter
import com.app.pizzahut.adapter.SelectionItem
import com.app.pizzahut.data.modals.dataModals.Pizza
import com.app.pizzahut.databinding.DialogFragmentPizzaOptionsBinding
import com.app.pizzahut.utils.onClick

class PizzaOptionsDialogFragment(val item: Pizza) : DialogFragment() {

    private lateinit var binding: DialogFragmentPizzaOptionsBinding

    private val viewModel: MainViewModel by activityViewModels()

    var crustAdapter = SelectionAdapter()

    var sizeAdapter = SelectionAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = DialogFragmentPizzaOptionsBinding.inflate(layoutInflater, container, false)
        binding.apply {
            name.text = item.name
            rvCrustList.adapter = crustAdapter
            rvSizeList.adapter = sizeAdapter
            addToCart.onClick {
                viewModel.addPizza(item.copy(),crustAdapter.selectedItemId,sizeAdapter.selectedItemId)
                dialog?.cancel()
            }
        }
        setCrustList(item.defaultCrust)
        return binding.root
    }

    fun setCrustList(selectedId: String) {
        item.crusts?.let { list ->
            crustAdapter.apply {
                selectedItemId = selectedId
                setAdapterList(list.map { SelectionItem(it.id, it.name) })
                onClick = { setSizeList(it) }
                setSizeList(selectedId)
            }

        }
    }

    fun setSizeList(selectedId: String) {
        val selectedCrust = item.crusts?.find { it.id == selectedId }
        selectedCrust?.sizes?.let { list ->
            sizeAdapter.apply {
                selectedItemId = selectedCrust.defaultSize ?: ""
                setAdapterList(list.map { SelectionItem(it.id, it.name) })
                onClick = { selectedId ->
                    val value = list.find { it.id == selectedId }?.price
                    binding.pizzaValue.text = "₹$value"
                }
                val value = list.find { it.id == selectedId }?.price
                binding.pizzaValue.text = "₹$value"
            }
        }
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.setLayout(
            resources.displayMetrics.widthPixels*3/4,
            resources.displayMetrics.heightPixels*3/4
        )
    }
}