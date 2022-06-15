package com.rama.notes.data.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory



const val BASE_URL="https://open-api.xyz/"
object WeatherApiServiceImpl {
    fun invoke(): WeatherApiService{
        val interceptor = Interceptor{
                chain ->
            val url= chain.request().url().newBuilder().addQueryParameter("access_key",API_KEY).build()
            val request = chain.request().newBuilder().url(url).build()
            return@Interceptor chain.proceed(request)
        }

        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()


        //val client = OkHttpClient.Builder().build()



        return Retrofit.Builder().client(client)
            //.baseUrl(BASE_URL)
            .baseUrl("http://api.weatherstack.com/")
            //.addCallAdapterFactory(CoroutineCallAdapterFactory())
            //.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            //.addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            //.addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(WeatherApiService::class.java)
    }

}



