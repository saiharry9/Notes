package com.rama.notes.data.network

import androidx.lifecycle.LiveData
import com.rama.notes.data.db.entity.current.Current
import com.rama.notes.data.db.entity.current.CurrentWeatherResponse

interface WeatherNetworkDataSource {
    val fetchedCurrent : LiveData<CurrentWeatherResponse>
    suspend fun fetchWeather(location:String) : Current
}