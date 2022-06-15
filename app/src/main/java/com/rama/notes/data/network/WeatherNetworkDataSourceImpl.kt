package com.rama.notes.data.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rama.notes.data.db.entity.current.Current
import com.rama.notes.data.db.entity.current.CurrentWeatherResponse

class WeatherNetworkDataSourceImpl (private val weatherApiService: WeatherApiService):WeatherNetworkDataSource {

    private val _fetchedCurrent = MutableLiveData<CurrentWeatherResponse>()

    override val fetchedCurrent : LiveData<CurrentWeatherResponse>
        get() = _fetchedCurrent

    override suspend fun fetchWeather(location: String):Current {
        return weatherApiService.getWeather(location).current
       //_fetchedCurrent.postValue(weather)
        //Log.i("Result",weather.toString())
    }

}