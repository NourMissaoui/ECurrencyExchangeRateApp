package com.example.ecurrencyexchangeapp.utils

import com.example.ecurrencyexchangeapp.data.remote.entities.currencyRateEntities.CurrencRateEntity
import com.example.ecurrencyexchangeapp.domain.model.Rates
import kotlin.reflect.full.instanceParameter

object utils {
    fun Rates.ratesToList(): List<CurrencRateEntity> {
        var currencies = mutableListOf<CurrencRateEntity>()
        Rates::class.members.forEach {
            val currency = CurrencRateEntity().apply {
                this.CountryName = it.name
                this.currencyRate = it.instanceParameter.toString()
            }
            currencies.add(currency)
        }
        return currencies.toList()
    }

}