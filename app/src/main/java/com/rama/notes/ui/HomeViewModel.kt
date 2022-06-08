package com.rama.notes.ui

import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rama.notes.ForecastApplication
import com.rama.notes.data.db.CurrentDao
import com.rama.notes.data.db.ForecastDatabase
import com.rama.notes.data.db.entity.current.Current
import com.rama.notes.data.network.WeatherApiService
import com.rama.notes.data.network.WeatherNetworkDataSourceImpl
import com.rama.notes.data.repository.ForecastRepository
import com.rama.notes.data.repository.ForecastRepositoryImpl
import com.rama.notes.util.lazyDeferred
import kotlinx.coroutines.*

class HomeViewModel(
    private val forecastRepository: ForecastRepository
) : ViewModel() {

    val weatherApiService= WeatherApiService.invoke()
    val weatherNetworkDataSourceImpl = WeatherNetworkDataSourceImpl(weatherApiService)


    suspend fun getWeatherFromDatabase() : LiveData<Current> {
        return forecastRepository.getWeather()
    }

    val weather by lazyDeferred {  forecastRepository.getWeather() }

     suspend fun getWeather(location:String) {
            withContext(Dispatchers.IO) {
                weatherNetworkDataSourceImpl.fetchWeather(location)
            }
        }

    // TODO: Implement the ViewModel
}