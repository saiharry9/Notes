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
}