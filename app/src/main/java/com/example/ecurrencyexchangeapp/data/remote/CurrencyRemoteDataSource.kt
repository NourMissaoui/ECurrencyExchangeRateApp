package com.example.ecurrencyexchangeapp.data.remote

import javax.inject.Inject

class CurrencyRemoteDataSource
@Inject constructor(
    private val currencyServices: CurrencyServices
) : BaseDataSource() {

    suspend fun getCurrencyExchangeRate(base: String) =
        getResult { currencyServices.changeBaseCurrency(base) }
}