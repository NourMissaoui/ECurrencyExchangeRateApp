package com.example.ecurrencyexchangeapp.domain.model


import kotlinx.serialization.SerialName


data class CurrencyRateRemoteEntities(
    @SerialName("base")
    val base: String? = "",
    @SerialName("date")
    val date: String? = "",
    @SerialName("rates")
    val rates: Rates? = Rates(),
    @SerialName("success")
    val success: Boolean? = false,
    @SerialName("timestamp")
    val timestamp: Int? = 0
)