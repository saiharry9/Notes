package com.rama.notes.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.rama.notes.data.db.entity.current.Current



@Database(
    entities = [Current::class],
    version = 1
)

abstract class ForecastDatabase : RoomDatabase() {
    abstract fun currentDao(): CurrentDao


    companion object {
        @Volatile private var instance: ForecastDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(context,
                    ForecastDatabase::class.java, "weatherEntries.db")
                    .build()
    }
}