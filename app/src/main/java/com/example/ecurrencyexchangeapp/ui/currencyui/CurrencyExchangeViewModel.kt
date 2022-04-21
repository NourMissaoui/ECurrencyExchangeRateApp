package com.example.ecurrencyexchangeapp.ui.currencyui

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.*
import com.example.ecurrencyexchangeapp.data.remote.entities.currencyRateEntities.CurrencRateEntity
import com.example.ecurrencyexchangeapp.domain.usecase.ExchangeRateUseCase
import com.example.ecurrencyexchangeapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrencyExchangeViewModel @Inject constructor(private val useCase: ExchangeRateUseCase) : ViewModel() {

    val _curencyList = MutableLiveData<Resource<List<CurrencRateEntity>?>>()
    var curencyList: LiveData<Resource<List<CurrencRateEntity>?>> = _curencyList

    suspend fun getCurrencyList(){
viewModelScope.launch {
    curencyList = useCase.getCurrencies().asLiveData()
    Log.i(TAG, "getCurrencyList: ${curencyList.value} ")  }

    }

}