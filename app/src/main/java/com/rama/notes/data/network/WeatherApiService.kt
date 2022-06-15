package com.rama.notes.data.network

import com.rama.notes.data.db.entity.current.CurrentWeatherResponse
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Path

//http://api.weatherstack.com/current?access_key=387d3d47cd8bf55ef788edfe8b73a526&query=New%20York
const val API_KEY="387d3d47cd8bf55ef788edfe8b73a526"

interface WeatherApiService {

    @GET("current")
    suspend fun getWeather(
        @Query("query")
        query: String
    ): CurrentWeatherResponse

}

