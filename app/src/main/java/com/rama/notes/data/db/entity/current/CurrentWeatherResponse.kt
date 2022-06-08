package com.rama.notes.data.db.entity.current

import com.rama.notes.data.db.entity.current.Current
import com.rama.notes.data.db.entity.current.Location
import com.rama.notes.data.db.entity.current.Request

data class CurrentWeatherResponse(
    val current: Current,
    val location: Location,
    val request: Request
)