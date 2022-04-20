package ru.gymbay.models.news

import com.squareup.moshi.Json
import ru.gymbay.models.CharsetInfo

data class NewsListObject(
    @field:Json(name = "charsetinfo")
    val charsetInfo: CharsetInfo?,
    @field:Json(name = "sitenews")
    val siteNews: List<News>?
)