package com.example.ecurrencyexchangeapp.domain.repository

import com.example.ecurrencyexchangeapp.domain.model.CurrencyRateRemoteEntities
import com.example.ecurrencyexchangeapp.utils.Resource

interface ICurrencyRepository  {
     suspend fun getCurrencyExchangeRate() : Resource<CurrencyRateRemoteEntities>
}