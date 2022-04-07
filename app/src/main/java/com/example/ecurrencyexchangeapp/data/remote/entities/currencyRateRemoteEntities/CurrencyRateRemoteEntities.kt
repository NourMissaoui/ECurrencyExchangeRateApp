package com.example.ecurrencyexchangeapp.data.remote.entities.currencyRateRemoteEntities

data class CurrencyRateRemoteEntities(
    val base: String,
    val date: String,
    val rates: Rates,
    val success: Boolean,
    val timestamp: Int
)