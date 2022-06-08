package com.rama.notes.data.db.entity.current

import androidx.room.Entity
import androidx.room.PrimaryKey


const val CURRENT_ID=0

@Entity(tableName="current")
data class Current(
    val cloudcover: Double,
    val feelslike: Double,
    val humidity: Double,
    val is_day: String,
    val observation_time: String,
    val precip: Double,
    val pressure: Double,
    val temperature: Double,
    val uv_index: Double,
    val visibility: Double,
    val weather_code: Double,
    //val weather_descriptions: List<String>,
    //val weather_icons: List<String>,
    val wind_degree: Double,
    val wind_dir: String,
    val wind_speed: Double
){
    @PrimaryKey(autoGenerate = false)
    var id: Int = CURRENT_ID
}