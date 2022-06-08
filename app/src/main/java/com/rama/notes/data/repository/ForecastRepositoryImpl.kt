package com.rama.notes.data.repository

import androidx.lifecycle.LiveData
import com.rama.notes.data.db.CurrentDao
import com.rama.notes.data.db.entity.current.Current
import com.rama.notes.data.network.WeatherNetworkDataSource
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ForecastRepositoryImpl(
    private val currentDao: CurrentDao,
    private val dataSource: WeatherNetworkDataSource
):ForecastRepository {

    init {
        dataSource.fetchedCurrent.observeForever { current ->
            GlobalScope.launch { currentDao.upsert(current = current.current) }
        }
    }

    override suspend fun getWeather(): LiveData<Current> {
        dataSource.fetchWeather("London")
        return currentDao.getCurrent()
    }
}