package com.app.pizzahut.repository

import com.app.pizzahut.api.ApiService
import com.app.pizzahut.data.modals.requestModals.GetAppListRequestModal
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class ApiRepository
@Inject constructor(
    private val apiServices: ApiService
) {
    fun getRestaurantList() = apiServices.getRestaurantList()

    fun getOrdersList() = apiServices.getOrdersList()
}