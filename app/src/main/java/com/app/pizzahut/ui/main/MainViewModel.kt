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
class MainViewModel @Inject constructor(): ViewModel() {

    @Inject
    lateinit var repo:ApiRepository

    private val _list = MutableLiveData<List<Pizza>>()
    val list: LiveData<List<Pizza>> = _list

    fun getPizzaList(){
        repo.getPizzaList().enqueue{
            it?.let{
                _list.value = it
            }
        }
    }

}