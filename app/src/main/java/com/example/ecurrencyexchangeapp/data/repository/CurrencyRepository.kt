package com.example.ecurrencyexchangeapp.data.repository

import com.example.ecurrencyexchangeapp.data.remote.CurrencyRemoteDataSource
import com.example.ecurrencyexchangeapp.data.remote.entities.currencyRateRemoteEntities.CurrencyRateRemoteEntities
import com.example.ecurrencyexchangeapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class CurrencyRepository @Inject constructor( private val currencyRemoteDataSource: CurrencyRemoteDataSource) : ICurrencyRepository {
    override suspend fun getCurrencyExchangeRate(base : String): Flow<Resource<CurrencyRateRemoteEntities>> = flowOf(currencyRemoteDataSource.getCurrencyExchangeRate(base))
}