package com.example.ecurrencyexchangeapp.di

import com.example.ecurrencyexchangeapp.utils.AppConstant
import com.example.ecurrencyexchangeapp.utils.AppConstant.BASE_URL
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {
    @Provides
    @Singleton
    fun provideHttpClient() = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val origin = chain.request()
            val url = origin.url.newBuilder().addEncodedQueryParameter(
                "access_key",
                AppConstant.API_access_Key
            ).build()
            val request = origin.newBuilder().url(url)
            chain.proceed(request.build())
        }
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }).build()

//    @Provides
//    fun provideGson(): Gson = GsonBuilder()
//        .create()

    @Singleton
    @Provides
    fun provideRetrofit( httpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient)
        .build()


}