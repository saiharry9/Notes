package com.rama.notes.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.rama.notes.data.db.CurrentDao
import com.rama.notes.data.db.entity.current.Current
import com.rama.notes.data.network.WeatherNetworkDataSourceImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ForecastRepositoryImpl(
    private val currentDao: CurrentDao,
    private val remoteDataSource: WeatherNetworkDataSourceImpl
):ForecastRepository {

    val current : LiveData<Current> by lazy {
        currentDao.getCurrent()
    }



   override suspend fun refreshWeather() {
        withContext(Dispatchers.IO) {
            val weather : Current = remoteDataSource.fetchWeather("London")
            Log.i("Network",weather.toString())
            //val weather: Current= WeatherApiService.invoke().getWeather("London").current
            currentDao.upsert(weather)
        }
    }

}