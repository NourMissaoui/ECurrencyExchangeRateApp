package com.example.ecurrencyexchangeapp.ui.currencyui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.ecurrencyexchangeapp.data.remote.entities.currencyRateEntities.CurrencRateEntity
import com.example.ecurrencyexchangeapp.domain.usecase.ExchangeRateUseCase
import com.example.ecurrencyexchangeapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

@HiltViewModel
class CurrencyExchangeViewModel @Inject constructor(private val useCase: ExchangeRateUseCase) : ViewModel() {

    val _curencyList = MutableLiveData<Resource<List<CurrencRateEntity>?>>()
    var curencyList: LiveData<Resource<List<CurrencRateEntity>?>> = _curencyList

    suspend fun getCurrencyList(base: String){
        curencyList =  useCase.getCurrencies(base).asLiveData()
    }
}