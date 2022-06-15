package com.rama.notes.ui

import android.app.Application
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
import com.rama.notes.data.network.WeatherApiServiceImpl
import com.rama.notes.data.network.WeatherNetworkDataSourceImpl
import com.rama.notes.data.repository.ForecastRepository
import com.rama.notes.data.repository.ForecastRepositoryImpl
import kotlinx.coroutines.*

class HomeViewModel(
    app: Application
) : ViewModel() {

    val weatherApiService= WeatherApiServiceImpl.invoke()
    val weatherNetworkDataSourceImpl = WeatherNetworkDataSourceImpl(weatherApiService)

    val forecastDatabase:ForecastDatabase = ForecastDatabase.invoke(app)
    private val forecastRepository = ForecastRepositoryImpl(forecastDatabase.currentDao(),weatherNetworkDataSourceImpl)

    init {
        refreshWeather()
    }

    val weather = forecastRepository.current

    private fun refreshWeather(){
        viewModelScope.launch {
            forecastRepository.refreshWeather()
        }
    }
}