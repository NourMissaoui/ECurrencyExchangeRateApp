package com.example.ecurrencyexchangeapp.data.remote

import com.example.ecurrencyexchangeapp.utils.AppConstant.API_access_Key
import retrofit2.Response
import retrofit2.http.GET

interface CurrencyServices {

    @GET("/latest ? access_key = $API_access_Key & base = {baseCurrency}")
    suspend fun changeBaseCurrency(baseCurrency : String) : Response<String>
}