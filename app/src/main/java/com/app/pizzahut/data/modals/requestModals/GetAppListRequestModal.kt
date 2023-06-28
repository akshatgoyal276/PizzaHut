package com.app.pizzahut.data.modals.requestModals

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GetAppListRequestModal(
    @SerializedName(value = "app_category") val category: String? = null
)
