package com.example.ecurrencyexchangeapp.data.remote

import android.util.Log
import com.example.ecurrencyexchangeapp.utils.Resource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

abstract class BaseDataSource {
    private val TAG = "BaseDataSource"

    protected suspend fun <T> getResult(call: suspend () -> Call<T>): Resource<T> {
        var result: Resource<T> = Resource.loading()
        Log.i(TAG, "getResult: $result")
        try {
            call().enqueue(object : Callback<T> {
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    response.body()?.let {
                        result = Resource.success(response.body()!!)
                        Log.i(TAG, "getResult: $result")

                    } ?: run {
                        result =
                            error("\"Network call has failed for a following reason: ${response.code()} ${response.message()}")
                        Log.i(TAG, "getResult: $result")
                    }
                }
                override fun onFailure(call: Call<T>, t: Throwable) {
                    result = error(t.message ?: t.toString())
                    Log.i(TAG, "getResult: $result throwable $t")
                }
            })
        } catch (e: Exception) {
            Log.i(TAG, "getResult: $result")

        }
        return result
    }

    private fun <T> error(message: String): Resource<T> {
        return Resource.error("Network call has failed for a following reason: $message")
    }
}
