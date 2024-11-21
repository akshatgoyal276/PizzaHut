package com.app.pizzahut.ui.main

import android.database.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.pizzahut.adapter.PizzaListAdapter
import com.app.pizzahut.api.enqueue
import com.app.pizzahut.data.modals.dataModals.Pizza
import com.app.pizzahut.repository.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    @Inject
    lateinit var repo: ApiRepository

    private var _selectedPizzaList = MutableLiveData<List<Pizza>>(listOf())
    var selectedPizzaList: LiveData<List<Pizza>> = _selectedPizzaList

    private val _list = MutableLiveData<List<Pizza>>()
    val list: LiveData<List<Pizza>> = _list

    fun getPizzaList() {
        val list = listOf(
            Pizza(id = "1", name = "Margherita",isVeg = true, description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry",),
            Pizza(),
        )
        _list.value = list
//        repo.getPizzaList().enqueue {
//            it?.let {
//                _list.value = it
//            }
//        }
    }

    fun addPizza(item: Pizza, crustId: String, sizeId: String){
        item.crusts?.find { it.id == crustId }?.let { crust ->
            crust.sizes?.find { it.id == sizeId }?.let { size ->
                val crustList = crust.copy(sizes = mutableListOf(size))
                val pizza = item.copy(crusts = mutableListOf(crustList))
                val list = mutableListOf<Pizza>()
                _selectedPizzaList.value?.let { list.addAll(it) }
                list.add(pizza)
                _selectedPizzaList.value = list
            }
        }
    }

    fun getCartCount(): String {
        val num = selectedPizzaList.value?.size
        return if (num == 1) "$num Item" else "$num Items"
    }

    fun getCartValue(): String {
        var amount = 0
        selectedPizzaList.value?.forEach { item ->
            amount += item.crusts?.firstOrNull()?.sizes?.firstOrNull()?.price ?: 0
        }
        return "₹$amount"
    }

}