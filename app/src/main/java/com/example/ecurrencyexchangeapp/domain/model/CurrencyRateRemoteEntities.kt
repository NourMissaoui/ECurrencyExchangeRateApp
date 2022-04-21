package com.example.ecurrencyexchangeapp.domain.model

import com.google.gson.annotations.SerializedName


data class CurrencyRateRemoteEntities(
    @SerializedName("success")
    val success: Boolean?,
    @SerializedName("timestamp")
    val timestamp: Int?,
    @SerializedName("base")
    val base: String?,
    @SerializedName("date")
    val date: String?,
    @SerializedName("rates")
    val rates: Rates?
)