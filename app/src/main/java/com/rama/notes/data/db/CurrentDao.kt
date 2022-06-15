package com.rama.notes.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rama.notes.data.db.entity.current.CURRENT_ID
import com.rama.notes.data.db.entity.current.Current


@Dao
interface CurrentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(current: Current)

    @Query("select * from current where id = $CURRENT_ID")
    fun getCurrent() : LiveData<Current>
}