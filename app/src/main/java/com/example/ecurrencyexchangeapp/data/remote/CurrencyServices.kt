package com.example.ecurrencyexchangeapp.data.remote

import com.example.ecurrencyexchangeapp.domain.model.CurrencyRateRemoteEntities
import retrofit2.Call
import retrofit2.http.GET

interface CurrencyServices {
     @GET("latest")
     fun changeBaseCurrency() : Call<CurrencyRateRemoteEntities>
}