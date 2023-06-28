package com.app.pizzahut.api

import android.util.Log
import com.app.pizzahut.data.modals.dataModals.AppData
import com.app.pizzahut.data.modals.requestModals.GetAppListRequestModal
import com.app.pizzahut.data.modals.responseModals.CustomListResponseModal
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET

interface ApiService {
    @GET("appList")
    fun getAppList(
        @Body data: GetAppListRequestModal
    ): Call<CustomListResponseModal<AppData>>
}

fun <T> Call<T>.enqueue(onComplete: (T?) -> Unit) {
    this.enqueue(object : Callback<T> {
        override fun onResponse(call: Call<T>, response: Response<T>) {
            if(response.isSuccessful){
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