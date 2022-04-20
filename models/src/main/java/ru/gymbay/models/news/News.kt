package ru.gymbay.models.news

import com.squareup.moshi.Json

data class News(
    val id: Int?,
    val tag: String?,
    val title: String?,
    @field:Json(name = "published_at")
    val publishedAt: String,
    @field:Json(name = "modified_at")
    val modifiedAt: String
)
