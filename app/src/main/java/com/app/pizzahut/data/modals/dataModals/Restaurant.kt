package com.app.pizzahut.data.modals.dataModals

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Restaurant(
    @Json(name = "id") val id: String = "",
    @Json(name = "title") val name: String = "",
    @Json(name = "distance") val distance: Int? = null,
    @Json(name = "image") val image: String = "",
)

@JsonClass(generateAdapter = true)
data class Order(
    @Json(name = "id") val id: String = "",
    @Json(name = "createdAt") val createdAt: String = "",
    @Json(name = "restaurantName") val restaurantName: String = "",
    @Json(name = "restaurantImage") val restaurantImage: String = "",
    @Json(name = "value") val distance: Int? = null,
)

@JsonClass(generateAdapter = true)
data class Dish(
    @Json(name = "id") val id: String = "",
    @Json(name = "name") val name: String = "",
    @Json(name = "size") val size: String = "",
    @Json(name = "isVeg") val isVeg: Boolean? = null,
    @Json(name = "value") val value: Int? = null,
)