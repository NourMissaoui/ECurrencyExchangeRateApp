package com.example.ecurrencyexchangeapp.data.repository

import com.example.ecurrencyexchangeapp.data.remote.entities.currencyRateRemoteEntities.CurrencyRateRemoteEntities
import com.example.ecurrencyexchangeapp.utils.Resource
import kotlinx.coroutines.flow.Flow

interface ICurrencyRepository  {

     suspend fun getCurrencyExchangeRate(base : String) : Flow<Resource<CurrencyRateRemoteEntities>>
}