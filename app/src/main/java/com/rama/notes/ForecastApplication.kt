package com.rama.notes

import android.app.Application
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import com.rama.notes.data.db.CurrentDao
import com.rama.notes.data.db.ForecastDatabase
import com.rama.notes.data.network.WeatherApiService
import com.rama.notes.data.network.WeatherNetworkDataSourceImpl
import com.rama.notes.data.repository.ForecastRepository
import com.rama.notes.data.repository.ForecastRepositoryImpl

class ForecastApplication: Application() {

    lateinit var weatherApiService: WeatherApiService
    lateinit var weatherNetworkDataSourceImpl :WeatherNetworkDataSourceImpl
    lateinit var currentDao:CurrentDao
    lateinit var forecastRepository:ForecastRepository

    override fun onCreate() {
        super.onCreate()
        weatherApiService = WeatherApiService.invoke()
        weatherNetworkDataSourceImpl = WeatherNetworkDataSourceImpl(weatherApiService)
        currentDao = ForecastDatabase.invoke(this.applicationContext).currentDao()
        forecastRepository = ForecastRepositoryImpl(currentDao,weatherNetworkDataSourceImpl)
    }

//    val weatherApiService: WeatherApiService
//        get() = WeatherApiService.invoke()
//    val weatherNetworkDataSourceImpl :WeatherNetworkDataSourceImpl
//        get() = WeatherNetworkDataSourceImpl(weatherApiService)
//
//    val currentDao:CurrentDao
//        get() = ForecastDatabase.invoke(this.applicationContext).currentDao()
//
//    val forecastRepository:ForecastRepository
//        get() = ForecastRepositoryImpl(currentDao,weatherNetworkDataSourceImpl)
}