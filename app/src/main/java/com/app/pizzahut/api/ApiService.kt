package com.app.pizzahut.api

import android.util.Log
import com.app.pizzahut.data.modals.dataModals.Dish
import com.app.pizzahut.data.modals.dataModals.Order
import com.app.pizzahut.data.modals.dataModals.Pizza
import com.app.pizzahut.data.modals.dataModals.Restaurant
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("test/restaurants")
    fun getRestaurantList(): Call<List<Restaurant>>

    @GET("test/orders")
    fun getOrdersList(): Call<List<Order>>

    @GET("test/dishes")
    fun getDishesList(): Call<List<Dish>>
}

fun <T> Call<T>.enqueue(onComplete: (T?) -> Unit) {
    this.enqueue(object : Callback<T> {
        override fun onResponse(call: Call<T>, response: Response<T>) {
            if (response.isSuccessful) {
                response.body()?.let {
                    onComplete(it)
                }
            } else onComplete(null)
        }

        override fun onFailure(call: Call<T>, t: Throwable) {
            Log.d("API Failure", "error: $t")
            onComplete(null)
        }
    })
}