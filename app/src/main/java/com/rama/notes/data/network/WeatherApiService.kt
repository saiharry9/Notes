package com.rama.notes.data.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.rama.notes.data.db.entity.current.CurrentWeatherResponse
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//http://api.weatherstack.com/current?access_key=387d3d47cd8bf55ef788edfe8b73a526&query=New%20York
const val API_KEY="387d3d47cd8bf55ef788edfe8b73a526"

interface WeatherApiService {

    @GET("current")
    fun getWeather(
         @Query("query")
         query:String
    ) : Deferred<CurrentWeatherResponse>

    companion object {
        fun invoke(): WeatherApiService{
            val interceptor = Interceptor{
                chain ->
                val url= chain.request().url().newBuilder().addQueryParameter("access_key",API_KEY).build()
                val request = chain.request().newBuilder().url(url).build()
                return@Interceptor chain.proceed(request)
            }

            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

            return Retrofit.Builder().client(client)
                .baseUrl("http://api.weatherstack.com/")
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(WeatherApiService::class.java)
        }

    }
}