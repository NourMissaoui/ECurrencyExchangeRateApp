package com.example.ecurrencyexchangeapp.di

import com.example.ecurrencyexchangeapp.data.remote.CurrencyRemoteDataSource
import com.example.ecurrencyexchangeapp.data.remote.CurrencyServices
import com.example.ecurrencyexchangeapp.data.repository.CurrencyRepository
import com.example.ecurrencyexchangeapp.domain.repository.ICurrencyRepository
import com.example.ecurrencyexchangeapp.domain.usecase.ExchangeRateUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
 class CurrencyExchangeModule {

    @Singleton
    @Provides
    fun provideCurrencyExchangeRateService(retrofit: Retrofit): CurrencyServices =
        retrofit.create(CurrencyServices::class.java)

    @Singleton
    @Provides
    fun provideDataSource(currencyServices: CurrencyServices) =
        CurrencyRemoteDataSource(currencyServices)

    @Singleton
    @Provides
   fun provideCurrencyRepository(currencyRemoteDataSource: CurrencyRemoteDataSource) : ICurrencyRepository =
        CurrencyRepository(currencyRemoteDataSource)

    @Singleton
    @Provides
    fun providecurrencurrencyUseCase(iCurrencyRepository: ICurrencyRepository) : ExchangeRateUseCase =
        ExchangeRateUseCase(iCurrencyRepository)
}