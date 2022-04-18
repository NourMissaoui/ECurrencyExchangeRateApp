package com.example.ecurrencyexchangeapp.data.repository

import com.example.ecurrencyexchangeapp.data.remote.CurrencyRemoteDataSource
import com.example.ecurrencyexchangeapp.domain.model.CurrencyRateRemoteEntities
import com.example.ecurrencyexchangeapp.domain.repository.ICurrencyRepository
import com.example.ecurrencyexchangeapp.utils.Resource
import com.example.ecurrencyexchangeapp.utils.utils.ratesToList
import javax.inject.Inject

class CurrencyRepository @Inject constructor(private val currencyRemoteDataSource: CurrencyRemoteDataSource) :
    ICurrencyRepository {
    override suspend fun getCurrencyExchangeRate(): Resource<CurrencyRateRemoteEntities>  = currencyRemoteDataSource.getCurrencyExchangeRate()
}