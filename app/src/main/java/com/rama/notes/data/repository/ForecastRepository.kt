package com.rama.notes.data.repository

import androidx.lifecycle.LiveData
import com.rama.notes.data.db.entity.current.Current

interface ForecastRepository {

    suspend fun getWeather(): LiveData< Current>
}