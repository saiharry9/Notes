package com.rama.notes.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rama.notes.data.repository.ForecastRepository





/**
 * Factory for constructing DevByteViewModel with parameter
 */
class HomeViewModelFactory(val app: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HomeViewModel(app) as T
        }
        throw IllegalArgumentException("Unable to construct viewmodel")
    }
}