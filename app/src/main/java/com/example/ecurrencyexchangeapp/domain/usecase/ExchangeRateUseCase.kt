package com.example.ecurrencyexchangeapp.domain.usecase

import com.example.ecurrencyexchangeapp.data.remote.entities.currencyRateEntities.CurrencRateEntity
import com.example.ecurrencyexchangeapp.domain.repository.ICurrencyRepository
import com.example.ecurrencyexchangeapp.utils.Resource
import com.example.ecurrencyexchangeapp.utils.utils.ratesToList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ExchangeRateUseCase
@Inject constructor(private val repository: ICurrencyRepository) {
    suspend fun getCurrencies(base: String): Flow<Resource<List<CurrencRateEntity>?>> {
        return flow {
            val data = repository.getCurrencyExchangeRate(base)
            try {
                val currencies = data.data?.rates?.ratesToList()
                emit(Resource.success(currencies))
            } catch (e: Exception) {
                emit(Resource.error(e.toString(), null))
            }
        }
    }
}