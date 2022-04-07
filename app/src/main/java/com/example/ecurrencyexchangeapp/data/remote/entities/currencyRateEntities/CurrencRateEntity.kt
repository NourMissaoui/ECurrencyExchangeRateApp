package com.example.ecurrencyexchangeapp.data.remote.entities.currencyRateEntities

import java.io.Serializable


data class CurrencRateEntity(
    val Falg: Int? = 0,
    val CountryName: String? = "",
    val currencyRate: Double? = 0.0
) : Serializable
