package com.app.pizzahut.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.pizzahut.api.enqueue
import com.app.pizzahut.data.modals.dataModals.Pizza
import com.app.pizzahut.repository.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    @Inject
    lateinit var repo: ApiRepository

    private var selectedPizzaList = mutableListOf<Pizza>()

    private val _list = MutableLiveData<List<Pizza>>()
    val list: LiveData<List<Pizza>> = _list

    fun getPizzaList() {
        repo.getPizzaList().enqueue {
            it?.let {
                _list.value = it
            }
        }
    }

    fun addPizza(item: Pizza, crustId: String?, sizeId: String?){
        val item = item.copy()
        val crust = item.crusts?.find { it.id == crustId }
        val size = crust?.sizes?.find { it.id == sizeId }
        crust?.sizes?.apply {
            clear()
            size?.let { add(it) }
        }
        item.crusts?.apply {
            clear()
            crust?.let { add(it) }
        }
        selectedPizzaList.add(item)
    }

    fun getCartCount(): String {
        val num = selectedPizzaList.size
        return if (num == 1) "$num Item" else "$num Items"
    }

    fun getCartValue(): String {
        var amount = 0
        for (item in selectedPizzaList) {
            amount += item.crusts?.firstOrNull()?.sizes?.firstOrNull()?.price ?: 0
        }
        return "₹$amount"
    }

}