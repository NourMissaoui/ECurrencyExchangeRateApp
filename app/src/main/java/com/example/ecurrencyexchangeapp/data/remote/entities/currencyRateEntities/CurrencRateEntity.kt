package com.example.ecurrencyexchangeapp.data.remote.entities.currencyRateEntities

import java.io.Serializable


data class CurrencRateEntity(
    var Falg: Int? = 0,
    var CountryName: String? = "",
    var currencyRate: String? = ""
) : Serializable
