package com.example.ecurrencyexchangeapp.di

import com.example.ecurrencyexchangeapp.data.remote.CurrencyRemoteDataSource
import com.example.ecurrencyexchangeapp.data.remote.CurrencyServices
import com.example.ecurrencyexchangeapp.data.repository.CurrencyRepository
import com.example.ecurrencyexchangeapp.data.repository.ICurrencyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
 object CurrencyExchangeModule {

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
}