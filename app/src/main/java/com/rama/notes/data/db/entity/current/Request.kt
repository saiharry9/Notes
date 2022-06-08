package com.rama.notes.data.db.entity.current

data class Request(
    val language: String,
    val query: String,
    val type: String,
    val unit: String
)