package com.app.pizzahut.data.modals.dataModals

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AppData(
    @SerializedName(value = "app_name") val name: String = "",
    @SerializedName(value = "app_description") val description: String = "",
    @SerializedName(value = "app_rating") val rating: Double = 0.0,
    @SerializedName(value = "app_size") val size: Double = 0.0,
)