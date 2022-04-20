package ru.gymbay.models.bond

import com.squareup.moshi.Json
import ru.gymbay.models.CharsetInfo

data class BondHistory(
    @field:Json(name = "charsetinfo")
    val charsetInfo: CharsetInfo?,
    val history: List<BondMarketInfo>?
)
