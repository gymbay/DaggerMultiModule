package ru.gymbay.models

import com.squareup.moshi.Json

data class BondHistory(
    @field:Json(name = "charsetinfo")
    val charsetInfo: CharsetInfo?,
    val history: List<BondMarketInfo>?
)
