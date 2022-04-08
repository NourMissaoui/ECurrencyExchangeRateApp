package com.example.ecurrencyexchangeapp.ui.currencyui

import androidx.lifecycle.ViewModel
import com.example.ecurrencyexchangeapp.domain.usecase.ExchangeRateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CurrencyExchangeViewModel @Inject constructor(useCase: ExchangeRateUseCase) :ViewModel(){



}