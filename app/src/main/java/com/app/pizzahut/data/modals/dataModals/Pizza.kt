package com.app.pizzahut.data.modals.dataModals

import android.view.View
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Pizza(
    @Json(name = "id") val id: String = "",
    @Json(name = "name") val name: String = "",
    @Json(name = "isVeg") val isVeg: Boolean? = null,
    @Json(name = "description") val description: String = "",
    @Json(name = "defaultCrust") val defaultCrust: String = "",
    @Json(name = "crusts") val crusts: MutableList<Crust>? = null,
){
    fun vegVisibility():Int{
        return if(isVeg == true) View.VISIBLE else View.GONE
    }

    fun nonVegVisibility():Int{
        return if(isVeg == false) View.VISIBLE else View.GONE
    }
}

@JsonClass(generateAdapter = true)
data class Crust(
    @Json(name = "id") val id: String = "",
    @Json(name = "name") val name: String = "",
    @Json(name = "defaultSize") val defaultSize: String? = null,
    @Json(name = "sizes") val sizes: MutableList<Size>? = null,
)

@JsonClass(generateAdapter = true)
data class Size(
    @Json(name = "id") val id: String = "",
    @Json(name = "name") val name: String = "",
    @Json(name = "price") val price: Int? = null,
)