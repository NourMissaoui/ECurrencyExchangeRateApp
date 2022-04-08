package com.example.ecurrencyexchangeapp.domain.model

data class CurrencyRateRemoteEntities(
    val base: String,
    val date: String,
    val rates: Rates,
    val success: Boolean,
    val timestamp: Int
)