package com.example.ecurrencyexchangeapp.data.remote

import com.example.ecurrencyexchangeapp.utils.AppConstant.API_access_Key
import javax.inject.Inject

class CurrencyRemoteDataSource
@Inject constructor(
    private val currencyServices: CurrencyServices
) : BaseDataSource() {

    suspend fun getCurrencyExchangeRate() =
        getResult { currencyServices.changeBaseCurrency() }
}