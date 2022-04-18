package com.example.ecurrencyexchangeapp.domain.usecase

import android.util.Log
import com.example.ecurrencyexchangeapp.data.remote.entities.currencyRateEntities.CurrencRateEntity
import com.example.ecurrencyexchangeapp.domain.repository.ICurrencyRepository
import com.example.ecurrencyexchangeapp.utils.Resource
import com.example.ecurrencyexchangeapp.utils.utils.ratesToList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ExchangeRateUseCase
@Inject constructor(private val repository: ICurrencyRepository) {
    val TAG = "ExchangeRateUseCase"
    suspend fun getCurrencies(): Flow<Resource<List<CurrencRateEntity>?>> {
        val data = repository.getCurrencyExchangeRate()
        return flow {
            emit(Resource.loading())
            try {
                val currencies = data.data?.rates?.ratesToList()
                Log.i(TAG, "getCurrencies: $currencies ")
                emit(Resource.success(currencies))
            } catch (e: Exception) {
                Log.i(TAG, "getCurrencies: ${e.message} ")
                emit(Resource.error(e.toString(), null))
            }
        }
    }
}